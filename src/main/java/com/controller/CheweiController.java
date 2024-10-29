package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.CheliangjiluEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.CheweiEntity;

import com.entity.view.CheweiView;
import com.entity.ChezhuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车位
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/chewei")
public class CheweiController {
    private static final Logger logger = LoggerFactory.getLogger(CheweiController.class);

    @Autowired
    private CheweiService cheweiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private ChezhuService chezhuService;
    @Autowired
    private CheliangjiluService cheliangjiluService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = cheweiService.queryPage(params);

        //字典表数据转换
        List<CheweiView> list =(List<CheweiView>)page.getList();
        for(CheweiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheweiEntity chewei = cheweiService.selectById(id);
        if(chewei !=null){
            //entity转view
            CheweiView view = new CheweiView();
            BeanUtils.copyProperties( chewei , view );//把实体数据重构到view中

            //级联表
            ChezhuEntity chezhu = chezhuService.selectById(chewei.getChezhuId());
            if(chezhu != null){
                BeanUtils.copyProperties( chezhu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setChezhuId(chezhu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CheweiEntity chewei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chewei:{}",this.getClass().getName(),chewei.toString());
        Wrapper<CheweiEntity> queryWrapper = new EntityWrapper<CheweiEntity>()
            .eq("chewei_name", chewei.getCheweiName());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheweiEntity cheweiEntity = cheweiService.selectOne(queryWrapper);
        if(cheweiEntity==null){
            chewei.setCheweiTypes(3);
            cheweiService.insert(chewei);
            return R.ok();
        }else {
            return R.error(511,"车位已被使用");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheweiEntity chewei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chewei:{}",this.getClass().getName(),chewei.toString());
        //根据字段查询是否有相同数据
        Wrapper<CheweiEntity> queryWrapper = new EntityWrapper<CheweiEntity>()
            .notIn("id",chewei.getId())
            .andNew()
            .eq("chewei_name", chewei.getCheweiName());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheweiEntity cheweiEntity = cheweiService.selectOne(queryWrapper);
        if(cheweiEntity==null){
            cheweiService.updateById(chewei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"车位已被使用");
        }
    }



    /**
     * 泊车
     */
    @RequestMapping("/boche")
    public R boche(@RequestParam String chepaihao, HttpServletRequest request){
        logger.debug("boche方法:,,Controller:{},,chepaihao:{}",this.getClass().getName(),chepaihao);

        List<CheweiEntity> lists = cheweiService.selectList(new EntityWrapper<CheweiEntity>().eq("chewei_types", 3));
        if(lists == null || lists.size()==0){
            return R.error(511,"没有空余车位");
        }else{
            CheweiEntity one = cheweiService.selectOne(new EntityWrapper<CheweiEntity>().eq("chepai_number", chepaihao));
            if(one != null){
                return R.error(511,"该车辆已经在园区内停车");
            }
            ChezhuEntity chezhu_chepai_number = chezhuService.selectOne(new EntityWrapper<ChezhuEntity>().eq("chezhu_chepai_number", chepaihao));
            CheweiEntity cheweiEntity = lists.get(0);
            if(chezhu_chepai_number != null){
                //园区车
                cheweiEntity.setChezhuId(chezhu_chepai_number.getId());
                cheweiEntity.setCheweiTypes(1);
            }else{
                //外来车
                cheweiEntity.setCheweiTypes(2);
            }
            cheweiEntity.setChepaiNumber(chepaihao);
            cheweiService.updateById(cheweiEntity);

            Date date = new Date();
            CheliangjiluEntity cheliangjiluEntity = new CheliangjiluEntity();
            cheliangjiluEntity.setCreateTime(date);
            cheliangjiluEntity.setInsertTime(date);
            cheliangjiluEntity.setChepaiNumber(chepaihao);
            cheliangjiluEntity.setCheweiId(cheweiEntity.getId());
            cheliangjiluEntity.setCheliangjiluTypes(1);
            cheliangjiluService.insert(cheliangjiluEntity);
            return R.ok();
        }
    }


    /**
     * 取车
     */
    @RequestMapping("/quche")
    public R quche(@RequestParam String chepaihao, HttpServletRequest request){
        logger.debug("quche方法:,,Controller:{},,chepaihao:{}",this.getClass().getName(),chepaihao);
        CheweiEntity cheweiEntity = cheweiService.selectOne(new EntityWrapper<CheweiEntity>().eq("chepai_number", chepaihao));
        if(cheweiEntity == null){
            return R.error(511,"您在本园区中没有停车");
        }else{
            CheliangjiluEntity cheliangjiluEntity = cheliangjiluService.selectOne(new EntityWrapper<CheliangjiluEntity>().eq("chepai_number", chepaihao).eq("cheliangjilu_types", 1));
            if(cheliangjiluEntity != null){
                Date date = new Date();
                Date insertTime = cheliangjiluEntity.getInsertTime();
                if(insertTime == null){
                    return R.error(511,"泊车时间为空");
                }
                long l = date.getTime() - insertTime.getTime();
                if(l<0){
                    return R.error(511,"取车时间不能小于泊车时间");
                }

                // 更新停车记录
                cheliangjiluEntity.setUpdateTime(date);
                cheliangjiluEntity.setCheliangjiluTypes(2);
                Integer xiaoshi = Integer.valueOf(String.valueOf(l / 1000 / 60 / 60))+1;
                cheliangjiluEntity.setXiaoshi(xiaoshi);
                cheliangjiluEntity.setMonery(xiaoshi*5);
                cheliangjiluService.updateById(cheliangjiluEntity);

                // 更新车位
                cheweiEntity.setCheweiTypes(3);
                cheweiEntity.setChepaiNumber(null);
                cheweiEntity.setChezhuId(null);
                cheweiService.updateAllColumnById(cheweiEntity);
                return R.ok();
            }else{
                return R.error(511,"您停车时没有生成停车记录,请联系管理员核实");
            }
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        cheweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}


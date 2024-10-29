package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.CheliangjiluEntity;

import com.service.CheliangjiluService;
import com.entity.view.CheliangjiluView;
import com.service.CheweiService;
import com.entity.CheweiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆记录
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/cheliangjilu")
public class CheliangjiluController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangjiluController.class);

    @Autowired
    private CheliangjiluService cheliangjiluService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private CheweiService cheweiService;


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
        PageUtils page = cheliangjiluService.queryPage(params);

        //字典表数据转换
        List<CheliangjiluView> list =(List<CheliangjiluView>)page.getList();
        for(CheliangjiluView c:list){
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
        CheliangjiluEntity cheliangjilu = cheliangjiluService.selectById(id);
        if(cheliangjilu !=null){
            //entity转view
            CheliangjiluView view = new CheliangjiluView();
            BeanUtils.copyProperties( cheliangjilu , view );//把实体数据重构到view中

            //级联表
            CheweiEntity chewei = cheweiService.selectById(cheliangjilu.getCheweiId());
            if(chewei != null){
                BeanUtils.copyProperties( chewei , view ,new String[]{ "id", "createDate", "chepaiNumber"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setCheweiId(chewei.getId());
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
    public R save(@RequestBody CheliangjiluEntity cheliangjilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliangjilu:{}",this.getClass().getName(),cheliangjilu.toString());
        Wrapper<CheliangjiluEntity> queryWrapper = new EntityWrapper<CheliangjiluEntity>()
            .eq("chepai_number", cheliangjilu.getChepaiNumber())
            .eq("chewei_id", cheliangjilu.getCheweiId())
            .eq("xiaoshi", cheliangjilu.getXiaoshi())
            .eq("monery", cheliangjilu.getMonery())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangjiluEntity cheliangjiluEntity = cheliangjiluService.selectOne(queryWrapper);
        if(cheliangjiluEntity==null){
            cheliangjilu.setInsertTime(new Date());
            cheliangjilu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      cheliangjilu.set
        //  }
            cheliangjiluService.insert(cheliangjilu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangjiluEntity cheliangjilu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,cheliangjilu:{}",this.getClass().getName(),cheliangjilu.toString());
        //根据字段查询是否有相同数据
        Wrapper<CheliangjiluEntity> queryWrapper = new EntityWrapper<CheliangjiluEntity>()
            .notIn("id",cheliangjilu.getId())
            .andNew()
            .eq("chepai_number", cheliangjilu.getChepaiNumber())
            .eq("chewei_id", cheliangjilu.getCheweiId())
            .eq("xiaoshi", cheliangjilu.getXiaoshi())
            .eq("monery", cheliangjilu.getMonery())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangjiluEntity cheliangjiluEntity = cheliangjiluService.selectOne(queryWrapper);
                cheliangjilu.setUpdateTime(new Date());
        if(cheliangjiluEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      cheliangjilu.set
            //  }
            cheliangjiluService.updateById(cheliangjilu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        cheliangjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}


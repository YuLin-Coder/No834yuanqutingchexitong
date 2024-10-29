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

import com.entity.ChezhuEntity;

import com.service.ChezhuService;
import com.entity.view.ChezhuView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车主
 * 后端接口
 * @author
 * @email
 * @date 2021-03-20
*/
@RestController
@Controller
@RequestMapping("/chezhu")
public class ChezhuController {
    private static final Logger logger = LoggerFactory.getLogger(ChezhuController.class);

    @Autowired
    private ChezhuService chezhuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


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
        PageUtils page = chezhuService.queryPage(params);

        //字典表数据转换
        List<ChezhuView> list =(List<ChezhuView>)page.getList();
        for(ChezhuView c:list){
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
        ChezhuEntity chezhu = chezhuService.selectById(id);
        if(chezhu !=null){
            //entity转view
            ChezhuView view = new ChezhuView();
            BeanUtils.copyProperties( chezhu , view );//把实体数据重构到view中

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
    public R save(@RequestBody ChezhuEntity chezhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chezhu:{}",this.getClass().getName(),chezhu.toString());
        Wrapper<ChezhuEntity> queryWrapper = new EntityWrapper<ChezhuEntity>()
            .eq("chezhu_id_number", chezhu.getChezhuIdNumber())
            .or()
            .eq("chezhu_chepai_number", chezhu.getChezhuChepaiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChezhuEntity chezhuEntity = chezhuService.selectOne(queryWrapper);
        if(chezhuEntity==null){
            chezhu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chezhu.set
        //  }
            chezhuService.insert(chezhu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChezhuEntity chezhu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chezhu:{}",this.getClass().getName(),chezhu.toString());
        //根据字段查询是否有相同数据
        Wrapper<ChezhuEntity> queryWrapper = new EntityWrapper<ChezhuEntity>()
            .notIn("id",chezhu.getId())
            .andNew()
            .eq("chezhu_id_number", chezhu.getChezhuIdNumber())
            .or()
            .eq("chezhu_chepai_number", chezhu.getChezhuChepaiNumber());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChezhuEntity chezhuEntity = chezhuService.selectOne(queryWrapper);
        if("".equals(chezhu.getChezhuPhoto()) || "null".equals(chezhu.getChezhuPhoto())){
                chezhu.setChezhuPhoto(null);
        }
        if(chezhuEntity==null){
            chezhuService.updateById(chezhu);//根据id更新
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
        chezhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}


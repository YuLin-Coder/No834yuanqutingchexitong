package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import com.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
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

import com.entity.XitonggonggaoEntity;

import com.service.XitonggonggaoService;
import com.entity.view.XitonggonggaoView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 系统公告
 * 后端接口
 * @author
 * @email
 * @date
*/
@RestController
@Controller
@RequestMapping("/xitonggonggao")
public class XitonggonggaoController {
    private static final Logger logger = LoggerFactory.getLogger(XitonggonggaoController.class);

    @Autowired
    private XitonggonggaoService xitonggonggaoService;


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
    PageUtils page = xitonggonggaoService.queryPage(params);

    //字典表数据转换
    List<XitonggonggaoView> list =(List<XitonggonggaoView>)page.getList();
        for(XitonggonggaoView c:list){
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
        XitonggonggaoEntity xitonggonggao = xitonggonggaoService.selectById(id);
        if(xitonggonggao !=null){
            //entity转view
            XitonggonggaoView view = new XitonggonggaoView();
            BeanUtils.copyProperties( xitonggonggao , view );//把实体数据重构到view中

            //字典表字典转换
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
    public R save(@RequestBody XitonggonggaoEntity xitonggonggao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xitonggonggao:{}",this.getClass().getName(),xitonggonggao.toString());
        Wrapper<XitonggonggaoEntity> queryWrapper = new EntityWrapper<XitonggonggaoEntity>()
            .eq("biaoti", xitonggonggao.getBiaoti())
            .eq("leixing", xitonggonggao.getLeixing())
            .eq("neirong", xitonggonggao.getNeirong())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XitonggonggaoEntity xitonggonggaoEntity = xitonggonggaoService.selectOne(queryWrapper);
        if(xitonggonggaoEntity==null){
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      xitonggonggao.set
        //  }
            xitonggonggao.setRiqi(new Date());
            xitonggonggao.setAddtime(new Date());
            xitonggonggaoService.insert(xitonggonggao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XitonggonggaoEntity xitonggonggao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xitonggonggao:{}",this.getClass().getName(),xitonggonggao.toString());
        //根据字段查询是否有相同数据
        Wrapper<XitonggonggaoEntity> queryWrapper = new EntityWrapper<XitonggonggaoEntity>()
            .notIn("id",xitonggonggao.getId())
            .eq("biaoti", xitonggonggao.getBiaoti())
            .eq("leixing", xitonggonggao.getLeixing())
            .eq("neirong", xitonggonggao.getNeirong())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XitonggonggaoEntity xitonggonggaoEntity = xitonggonggaoService.selectOne(queryWrapper);
        if(xitonggonggaoEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xitonggonggao.set
            //  }
            xitonggonggaoService.updateById(xitonggonggao);//根据id更新
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
        xitonggonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}


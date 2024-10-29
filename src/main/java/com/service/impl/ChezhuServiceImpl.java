package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ChezhuDao;
import com.entity.ChezhuEntity;
import com.service.ChezhuService;
import com.entity.view.ChezhuView;

/**
 * 车主 服务实现类
 * @author 
 * @since 2021-03-20
 */
@Service("chezhuService")
@Transactional
public class ChezhuServiceImpl extends ServiceImpl<ChezhuDao, ChezhuEntity> implements ChezhuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChezhuView> page =new Query<ChezhuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}

package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XitonggonggaoEntity;
import java.util.Map;

/**
 * 系统公告 服务类
 * @author 
 * @since 2021-03-20
 */
public interface XitonggonggaoService extends IService<XitonggonggaoEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}
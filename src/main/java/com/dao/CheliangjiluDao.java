package com.dao;

import com.entity.CheliangjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangjiluView;

/**
 * 车辆记录 Dao 接口
 *
 * @author 
 * @since 2021-03-20
 */
public interface CheliangjiluDao extends BaseMapper<CheliangjiluEntity> {

   List<CheliangjiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

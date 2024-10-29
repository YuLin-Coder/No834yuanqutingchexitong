package com.dao;

import com.entity.CheweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CheweiView;

/**
 * 车位 Dao 接口
 *
 * @author 
 * @since 2021-03-20
 */
public interface CheweiDao extends BaseMapper<CheweiEntity> {

   List<CheweiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

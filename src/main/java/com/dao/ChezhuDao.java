package com.dao;

import com.entity.ChezhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChezhuView;

/**
 * 车主 Dao 接口
 *
 * @author 
 * @since 2021-03-20
 */
public interface ChezhuDao extends BaseMapper<ChezhuEntity> {

   List<ChezhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

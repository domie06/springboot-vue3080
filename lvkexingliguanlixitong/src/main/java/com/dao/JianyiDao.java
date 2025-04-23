package com.dao;

import com.entity.JianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianyiView;

/**
 * 建议 Dao 接口
 *
 * @author 
 */
public interface JianyiDao extends BaseMapper<JianyiEntity> {

   List<JianyiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

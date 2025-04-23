package com.dao;

import com.entity.XingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XingliView;

/**
 * 行李托运 Dao 接口
 *
 * @author 
 */
public interface XingliDao extends BaseMapper<XingliEntity> {

   List<XingliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

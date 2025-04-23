package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianyiEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 建议 服务类
 */
public interface JianyiService extends IService<JianyiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.IndexConfig;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-16-7:28
 */
public interface NewBeeMallIndexConfigService {
    /**
     * 后台分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<IndexConfig> getConfigPage(Integer pageNum, Integer pageSize, Byte configType);

    /**
     * 增加
     *
     * @param indexConfig
     * @return
     */
    String saveIndexConfig(IndexConfig indexConfig);

    /**
     * 修改
     *
     * @param indexConfig
     * @return
     */
    String updateIndexConfig(IndexConfig indexConfig);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(List<Long> ids);
}

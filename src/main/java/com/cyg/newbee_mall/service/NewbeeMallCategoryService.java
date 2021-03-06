package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.GoodsCatefory;
import com.cyg.newbee_mall.util.PageQueryUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author CuiYuangeng
 * @create 2021-12-13-7:25
 */
public interface NewbeeMallCategoryService {

    PageInfo<GoodsCatefory> selectAllLimit(Integer pageNum, Integer pageSize, Byte categoryLevel, Long parentId);

    PageInfo<GoodsCatefory> selectAllLimit(PageQueryUtil pageQueryUtil, Map<String, Object> params);

    String saveCategory(GoodsCatefory goodsCatefory);

    String updateGoodsCategory(GoodsCatefory goodsCatefory);

    /**
     * @param categoryId
     * @return
     */
    GoodsCatefory getGoodsCategory(Long categoryId);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(List<Long> ids);

    /**
     * 根据parentId categoryLevel 查询分类列表
     *
     * @param parentIds
     * @param categoryLevel
     * @return
     */
    List<GoodsCatefory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, Byte categoryLevel);
}

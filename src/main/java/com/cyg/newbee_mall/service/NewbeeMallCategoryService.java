package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.GoodsCatefory;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-13-7:25
 */
public interface NewbeeMallCategoryService {
    PageInfo<GoodsCatefory> selectAllLimit(Byte categoryLevel, Long categoryId, Long parentId
            , Integer pageNum, Integer pageSize);

    String saveCategory(GoodsCatefory goodsCatefory);

    String updateGoodsCategory(GoodsCatefory goodsCatefory);

    GoodsCatefory getGoodsCategory(Long categoryId);

    Boolean deleteBatch(List<Integer> ids);
}

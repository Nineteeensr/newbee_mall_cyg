package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.Carousel;
import com.cyg.newbee_mall.util.PageQueryUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author CuiYuangeng
 * @create 2021-12-10-9:42
 */
public interface NewBeeMallCarouselService {
    /**
     * 查询后台管理系统 轮播图 分页数据
     *
     * @param
     * @param
     * @return
     */
    PageInfo<Carousel> selectCarousel(PageQueryUtil pageQueryUtil, Map<String, Object> params);

    /**
     * 新增一条轮播数据
     *
     * @param carousel
     * @return
     */
    String saveCarousel(Carousel carousel);

    /**
     * 修改轮播图数据
     *
     * @param carousel
     * @return
     */
    String updateCarousel(Carousel carousel);

    /**
     * 根据主键查询数据
     *
     * @param id
     * @return
     */
    Carousel selectCarouselById(Integer id);

    /**
     * 批量删除数据
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(List<Integer> ids);


}

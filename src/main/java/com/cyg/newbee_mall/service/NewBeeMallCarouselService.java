package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.Carousel;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-10-9:42
 */
public interface NewBeeMallCarouselService {
    PageInfo<Carousel> selectCarousel(Integer pageNum, Integer pageSize);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel selectCarouselById(Integer id);

    Boolean deleteBatch(List<Integer> ids);
}

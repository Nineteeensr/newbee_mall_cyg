package com.cyg.newbee_mall.service.impl;

import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.mapper.CarouselMapper;
import com.cyg.newbee_mall.pojo.Carousel;
import com.cyg.newbee_mall.pojo.CarouselExample;
import com.cyg.newbee_mall.service.NewBeeMallCarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-10-9:43
 */
@Service
public class NewBeeMallCarouselServiceImpl implements NewBeeMallCarouselService {
    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public PageInfo<Carousel> selectCarousel(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Carousel> carousels = carouselMapper.selectByExample(null);
        PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
        return pageInfo;
    }

    @Override
    public String saveCarousel(Carousel carousel) {
        if (carouselMapper.insertSelective(carousel) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateCarousel(Carousel carousel) {
        Carousel temp = carouselMapper.selectByPrimaryKey(carousel.getCarouselId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        temp.setCarouselRank(carousel.getCarouselRank());
        temp.setRedirectUrl(carousel.getRedirectUrl());
        temp.setCarouselUrl(carousel.getCarouselUrl());
        temp.setUpdateTime(new Date());
        if (carouselMapper.updateByPrimaryKeySelective(temp) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Carousel selectCarouselById(Integer id) {
        return carouselMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        CarouselExample example = new CarouselExample();
        example.createCriteria().andCarouselIdIn(ids);
        return carouselMapper.deleteByExample(example) > 0;
    }
}

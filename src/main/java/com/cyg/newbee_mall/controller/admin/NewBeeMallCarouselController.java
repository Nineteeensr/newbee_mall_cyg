package com.cyg.newbee_mall.controller.admin;

import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.pojo.Carousel;
import com.cyg.newbee_mall.service.NewBeeMallCarouselService;
import com.cyg.newbee_mall.util.PageQueryUtil;
import com.cyg.newbee_mall.util.Result;
import com.cyg.newbee_mall.util.ResultGenerator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author CuiYuangeng
 * @create 2021-12-10-7:26
 */
@Controller
@RequestMapping("/admin")
public class NewBeeMallCarouselController {
    @Resource
    NewBeeMallCarouselService newBeeMallCarouselService;

    @GetMapping("/carousels")
    public String carouselPage(Model model) {
        model.addAttribute("path", "newbee_mall_carousels");
        return "admin/newbee_mall_carousel";
    }

    /**
     * 列表
     *
     * @param
     * @param
     * @return
     */
    @GetMapping("/carousels/list")
    @ResponseBody
    public Result list(
            @RequestParam Map<String, Object> params
    ) {
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        PageInfo<Carousel> pageInfo = newBeeMallCarouselService.selectCarousel(pageQueryUtil, params);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/carousels/save")
    @ResponseBody
    public Result save(@RequestBody Carousel carousel) {
        if (StringUtils.isEmpty(carousel.getCarouselUrl())
                || Objects.isNull(carousel.getCarouselRank())) {
            return ResultGenerator.genFailResult("参数异常");
        }
        String result = newBeeMallCarouselService.saveCarousel(carousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改
     *
     * @param carousel
     * @return
     */
    @PostMapping("/carousels/update")
    @ResponseBody
    public Result update(@RequestBody Carousel carousel) {
        if (Objects.isNull(carousel.getCarouselId())
                || StringUtils.isEmpty(carousel.getCarouselUrl())
                || Objects.isNull(carousel.getCarouselRank())) {
            return ResultGenerator.genFailResult("参数异常");
        }
        String result = newBeeMallCarouselService.updateCarousel(carousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/carousels/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Integer id) {
        Carousel carousel = newBeeMallCarouselService.selectCarouselById(id);
        if (carousel == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResult(carousel);
    }

    @PostMapping("/carousels/delete")
    @ResponseBody
    public Result delete(@RequestBody List<Integer> ids) {
        if (ids.size() < 1) {
            return ResultGenerator.genFailResult("参数异常");
        }
        if (newBeeMallCarouselService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}

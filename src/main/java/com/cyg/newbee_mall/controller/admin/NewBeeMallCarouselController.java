package com.cyg.newbee_mall.controller.admin;

import com.cyg.newbee_mall.pojo.Carousel;
import com.cyg.newbee_mall.service.NewBeeMallCarouselService;
import com.cyg.newbee_mall.util.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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

    @GetMapping("/carousels/list")
    @ResponseBody
    public Result list(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize
    ) {
        PageInfo<Carousel> pageInfo = newBeeMallCarouselService.selectCarousel(pageNum, pageSize);
        return null;
    }
}

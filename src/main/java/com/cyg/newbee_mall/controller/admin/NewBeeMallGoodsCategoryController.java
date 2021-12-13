package com.cyg.newbee_mall.controller.admin;

import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.pojo.GoodsCatefory;
import com.cyg.newbee_mall.service.NewbeeMallCategoryService;
import com.cyg.newbee_mall.util.Result;
import com.cyg.newbee_mall.util.ResultGenerator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author CuiYuangeng
 * @create 2021-12-14-7:11
 */
@Controller
@RequestMapping("/admin")
public class NewBeeMallGoodsCategoryController {
    @Resource
    NewbeeMallCategoryService newbeeMallCategoryService;

    /**
     * 页面跳转
     *
     * @param model
     * @param categoryLevel
     * @param parentId
     * @param backParentId
     * @return
     */
    @GetMapping("/categories")
    public String categoriesPage(Model model, @RequestParam("categoryLevel") Byte categoryLevel
            , @RequestParam("parentId") Long parentId
            , @RequestParam("backParentId") Long backParentId) {
        if (categoryLevel == null || categoryLevel < 1 || categoryLevel > 3) {
            return "error/error_5xx";
        }
        model.addAttribute("path", "newbee_mall_category");
        model.addAttribute("parentId", parentId);
        model.addAttribute("categoryLevel", categoryLevel);
        model.addAttribute("backParentId", backParentId);
        return "admin/newbee_mall_category";
    }

    /**
     * 列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/categories/list")
    @ResponseBody
    public Result list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<GoodsCatefory> pageInfo = newbeeMallCategoryService.selectAllLimit(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 添加
     *
     * @param goodsCategory
     * @return
     */
    @PostMapping("/categories/save")
    @ResponseBody
    public Result save(@RequestBody GoodsCatefory goodsCategory) {
        if (Objects.isNull(goodsCategory.getCategoryLevel())
                || StringUtils.isEmpty(goodsCategory.getCategoryName())
                || Objects.isNull(goodsCategory.getParentId())
                || Objects.isNull(goodsCategory.getCategoryRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = newbeeMallCategoryService.saveCategory(goodsCategory);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }
}

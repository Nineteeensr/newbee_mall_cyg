package com.cyg.newbee_mall.controller.admin;

import com.cyg.newbee_mall.common.NewBeeMallCategoryLevelEnum;
import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.pojo.GoodsCatefory;
import com.cyg.newbee_mall.service.NewbeeMallCategoryService;
import com.cyg.newbee_mall.util.Result;
import com.cyg.newbee_mall.util.ResultGenerator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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
     * @param
     * @param
     * @return
     */
    @GetMapping("/categories/list")
    @ResponseBody
    public Result list(@RequestParam(value = "page") Integer page
            , @RequestParam(value = "limit") Integer limit
            , @RequestParam(value = "categoryLevel", defaultValue = "1") Byte categoryLevel
            , @RequestParam(value = "parentId", defaultValue = "0") Long parentId) {
        PageInfo<GoodsCatefory> pageInfo = newbeeMallCategoryService.selectAllLimit(page, limit, categoryLevel, parentId);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    /*public Result list(@RequestParam Map<String,Object> params){
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        PageInfo<GoodsCatefory> pageInfo = newbeeMallCategoryService.selectAllLimit(pageQueryUtil, params);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/

    @GetMapping("/categories/listForSelect")
    @ResponseBody
    public Result listForSelect(@RequestParam Long categoryId) {
        if (categoryId == null || categoryId < 1) {
            return ResultGenerator.genFailResult("缺少参数!");
        }
        GoodsCatefory category = newbeeMallCategoryService.getGoodsCategory(categoryId);
        if (category == null || category.getCategoryLevel() == NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ResultGenerator.genFailResult("参数异常");
        }
        Map categoryResult = new HashMap(4);
        if (category.getCategoryLevel() == NewBeeMallCategoryLevelEnum.LEVEL_ONE.getLevel()) {
            List<GoodsCatefory> secondLevelCategories = newbeeMallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(categoryId), (byte) NewBeeMallCategoryLevelEnum.LEVEL_TWO.getLevel());
            if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                List<GoodsCatefory> thirdLevelCategories = newbeeMallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelCategories.get(0).getCategoryId()), (byte) NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel());
                categoryResult.put("secondLevelCategories", secondLevelCategories);
                categoryResult.put("thirdLevelCategories", thirdLevelCategories);
            }
        }
        if (category.getCategoryLevel() == NewBeeMallCategoryLevelEnum.LEVEL_TWO.getLevel()) {
            List<GoodsCatefory> thirdLevelCategories = newbeeMallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(categoryId), (byte) NewBeeMallCategoryLevelEnum.LEVEL_THREE.getLevel());
            categoryResult.put("thirdLevelCategories", thirdLevelCategories);
        }
        return ResultGenerator.genSuccessResult(categoryResult);
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

    @GetMapping("/categories/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        GoodsCatefory goodsCategory = newbeeMallCategoryService.getGoodsCategory(id);
        if (goodsCategory == null) {
            return ResultGenerator.genFailResult("未查询到数据");
        }
        return ResultGenerator.genSuccessResult(goodsCategory);
    }

    @PostMapping("/categories/update")
    @ResponseBody
    public Result update(@RequestBody GoodsCatefory goodsCategory) {
        if (Objects.isNull(goodsCategory.getCategoryId())
                || Objects.isNull(goodsCategory.getCategoryLevel())
                || StringUtils.isEmpty(goodsCategory.getCategoryName())
                || Objects.isNull(goodsCategory.getParentId())
                || Objects.isNull(goodsCategory.getCategoryRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = newbeeMallCategoryService.updateGoodsCategory(goodsCategory);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @PostMapping("/categories/delete")
    @ResponseBody
    public Result delete(@RequestBody List<Long> ids) {
        if (ids.size() < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (newbeeMallCategoryService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}

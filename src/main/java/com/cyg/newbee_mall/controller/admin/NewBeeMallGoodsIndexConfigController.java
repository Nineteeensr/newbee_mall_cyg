package com.cyg.newbee_mall.controller.admin;

import com.cyg.newbee_mall.common.IndexConfigTypeEnum;
import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.pojo.IndexConfig;
import com.cyg.newbee_mall.service.NewBeeMallIndexConfigService;
import com.cyg.newbee_mall.util.Result;
import com.cyg.newbee_mall.util.ResultGenerator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author CuiYuangeng
 * @create 2021-12-16-7:57
 */
@Controller
@RequestMapping("/admin")
public class NewBeeMallGoodsIndexConfigController {
    @Resource
    NewBeeMallIndexConfigService indexConfigService;

    @GetMapping("/indexConfigs")
    public String indexConfigPages(Model model, @RequestParam("configType") Byte configType) {
        IndexConfigTypeEnum indexConfigTypeEnum = IndexConfigTypeEnum.getIndexConfigTypeEnumByType(configType);
        if (indexConfigTypeEnum.equals(IndexConfigTypeEnum.DEFAULT)) {
            return "error/error_5xx";
        }
        model.addAttribute("path", indexConfigTypeEnum.getName());
        model.addAttribute("configType", configType);
        return "admin/newbee_mall_index_config";
    }

    /**
     * 分页列表
     *
     * @param page
     * @param limit
     * @param configType
     * @return
     */
    @GetMapping("/indexConfigs/list")
    @ResponseBody
    public Result list(
            @RequestParam(value = "page") Integer page
            , @RequestParam(value = "limit") Integer limit
            , @RequestParam(value = "configType") Byte configType) {
        PageInfo<IndexConfig> pageInfo = indexConfigService.getConfigPage(page, limit, configType);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 添加
     *
     * @param indexConfig
     * @return
     */
    @RequestMapping(value = "/indexConfigs/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody IndexConfig indexConfig) {
        if (Objects.isNull(indexConfig.getConfigType())
                || StringUtils.isEmpty(indexConfig.getConfigName())
                || Objects.isNull(indexConfig.getConfigRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = indexConfigService.saveIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改
     *
     * @param indexConfig
     * @return
     */
    @RequestMapping(value = "/indexConfigs/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody IndexConfig indexConfig) {
        if (Objects.isNull(indexConfig.getConfigType())
                || Objects.isNull(indexConfig.getConfigId())
                || StringUtils.isEmpty(indexConfig.getConfigName())
                || Objects.isNull(indexConfig.getConfigRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = indexConfigService.updateIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 详情
     * @param id
     * @return
     */
    //@GetMapping("/indexConfigs/info/{id}")
    //@ResponseBody
    //public Result info(@PathVariable("id") Long id) {
    //    IndexConfig config = indexConfigService.getIndexConfigById(id);
    //    if (config == null) {
    //        return ResultGenerator.genFailResult("未查询到数据");
    //    }
    //    return ResultGenerator.genSuccessResult(config);
    //}

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/indexConfigs/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody List<Long> ids) {
        if (ids.size() < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (indexConfigService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}

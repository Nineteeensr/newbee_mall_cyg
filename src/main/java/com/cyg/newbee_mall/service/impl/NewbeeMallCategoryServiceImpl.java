package com.cyg.newbee_mall.service.impl;

import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.mapper.GoodsCateforyMapper;
import com.cyg.newbee_mall.pojo.GoodsCatefory;
import com.cyg.newbee_mall.pojo.GoodsCateforyExample;
import com.cyg.newbee_mall.service.NewbeeMallCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-13-7:37
 */
@Service
public class NewbeeMallCategoryServiceImpl implements NewbeeMallCategoryService {
    @Resource
    private GoodsCateforyMapper goodsCateforyMapper;

    /**
     * 分页查询后台 分类 管理数据
     *
     * @return
     */
    @Override
    public PageInfo<GoodsCatefory> selectAllLimit(Integer pageNum, Integer pageSize, Byte categoryLevel, Long parentId) {
        System.out.println("pageNum = " + pageNum);
        System.out.println("pageSize = " + pageSize);
        System.out.println("categoryLevel = " + categoryLevel);
        System.out.println("parentId = " + parentId);
        PageHelper.startPage(pageNum, pageSize);
        GoodsCateforyExample example = new GoodsCateforyExample();
        example.setOrderByClause("category_rank desc");

        example.createCriteria().andCategoryLevelEqualTo(categoryLevel).andParentIdEqualTo(parentId);
        List<GoodsCatefory> goodsCatefories = goodsCateforyMapper.selectByExample(example);
        PageInfo<GoodsCatefory> pageInfo = new PageInfo<>(goodsCatefories);

        return pageInfo;
    }

    /**
     * 保存一条数据
     *
     * @param goodsCatefory
     * @return
     */
    @Override
    public String saveCategory(GoodsCatefory goodsCatefory) {
        GoodsCateforyExample example = new GoodsCateforyExample();
        example.createCriteria().andCategoryLevelEqualTo(goodsCatefory.getCategoryLevel())
                .andCategoryNameEqualTo(goodsCatefory.getCategoryName());
        List<GoodsCatefory> goodsCatefories = goodsCateforyMapper.selectByExample(example);
        if (goodsCatefories.size() > 0 && goodsCatefories != null) {
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if (goodsCateforyMapper.insertSelective(goodsCatefory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 修改一条数据
     *
     * @return
     */
    @Override
    public String updateGoodsCategory(GoodsCatefory goodsCategory) {
        GoodsCatefory temp = goodsCateforyMapper.selectByPrimaryKey(goodsCategory.getCategoryId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        GoodsCateforyExample example = new GoodsCateforyExample();
        example.createCriteria().andCategoryLevelEqualTo(goodsCategory.getCategoryLevel()).andCategoryNameEqualTo(goodsCategory.getCategoryName());
        List<GoodsCatefory> goodsCatefories = goodsCateforyMapper.selectByExample(example);
        GoodsCatefory temp2 = null;
        if (goodsCatefories.size() > 0 && goodsCatefories != null) {
            temp2 = goodsCatefories.get(0);
        }
        if (temp2 != null && !temp2.getCategoryId().equals(goodsCategory.getCategoryId())) {
            //同名且不同id 不能继续修改
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        goodsCategory.setUpdateTime(new Date());
        if (goodsCateforyMapper.updateByPrimaryKeySelective(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 根据主键查询
     *
     * @param categoryId
     * @return
     */
    @Override
    public GoodsCatefory getGoodsCategory(Long categoryId) {
        return goodsCateforyMapper.selectByPrimaryKey(categoryId);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteBatch(List<Long> ids) {
        GoodsCateforyExample example = new GoodsCateforyExample();
        example.createCriteria().andCategoryIdIn(ids);
        return goodsCateforyMapper.deleteByExample(example) > 0;
    }

    /**
     * 根据parentId和Level查询列表
     *
     * @param parentIds
     * @param categoryLevel
     * @return
     */
    @Override
    public List<GoodsCatefory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, Byte categoryLevel) {
        GoodsCateforyExample example = new GoodsCateforyExample();
        example.createCriteria().andParentIdIn(parentIds).andCategoryLevelEqualTo(categoryLevel);
        List<GoodsCatefory> goodsCatefories = goodsCateforyMapper.selectByExample(example);
        return goodsCatefories;
    }

}

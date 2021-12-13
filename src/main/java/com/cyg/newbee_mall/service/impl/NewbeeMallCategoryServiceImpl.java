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
     * @param categoryLevel
     * @param categoryId
     * @param parentId
     * @return
     */
    @Override
    public PageInfo<GoodsCatefory> selectAllLimit(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        GoodsCateforyExample example = new GoodsCateforyExample();
        GoodsCateforyExample.Criteria criteria = example.createCriteria();
        //if (categoryLevel != 0) {
        //    criteria.andCategoryLevelEqualTo(categoryLevel);
        //}
        //if (categoryId != 0) {
        //    criteria.andCategoryIdEqualTo(categoryId);
        //}
        //if (parentId != 0) {
        //    criteria.andParentIdEqualTo(parentId);
        //}
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
     * @param goodsCatefory
     * @return
     */
    @Override
    public String updateGoodsCategory(GoodsCatefory goodsCatefory) {
        GoodsCatefory temp = goodsCateforyMapper.selectByPrimaryKey(goodsCatefory.getCategoryId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        GoodsCateforyExample example = new GoodsCateforyExample();
        example.createCriteria().andCategoryLevelEqualTo(goodsCatefory.getCategoryLevel())
                .andCategoryNameEqualTo(goodsCatefory.getCategoryName());
        List<GoodsCatefory> temp2 = goodsCateforyMapper.selectByExample(example);
        if (temp2 != null && temp2.get(0).getCategoryId().equals(goodsCatefory.getCategoryId())) {

        }
        return null;
    }

    /**
     * 根据主键查询
     *
     * @param categoryId
     * @return
     */
    @Override
    public GoodsCatefory getGoodsCategory(Long categoryId) {
        return null;
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteBatch(List<Integer> ids) {
        return null;
    }
}

package com.cyg.newbee_mall.service.impl;

import com.cyg.newbee_mall.common.ServiceResultEnum;
import com.cyg.newbee_mall.mapper.IndexConfigMapper;
import com.cyg.newbee_mall.mapper.NewBeeMallGoodsMapper;
import com.cyg.newbee_mall.pojo.IndexConfig;
import com.cyg.newbee_mall.pojo.IndexConfigExample;
import com.cyg.newbee_mall.service.NewBeeMallIndexConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-16-7:31
 */
@Service
public class NewBeeMallIndexConfigServiceImpl implements NewBeeMallIndexConfigService {
    @Resource
    private IndexConfigMapper indexConfigMapper;

    @Resource
    private NewBeeMallGoodsMapper goodsMapper;

    /**
     * 后台分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<IndexConfig> getConfigPage(Integer pageNum, Integer pageSize, Byte configType) {
        PageHelper.startPage(pageNum, pageSize);
        IndexConfigExample example = new IndexConfigExample();
        example.setOrderByClause("config_rank desc");
        example.createCriteria().andConfigTypeEqualTo(configType);
        List<IndexConfig> indexConfigs = indexConfigMapper.selectByExample(example);
        PageInfo<IndexConfig> pageInfo = new PageInfo<>(indexConfigs);
        return pageInfo;
    }

    /**
     * 增加
     *
     * @param indexConfig
     * @return
     */
    @Override
    public String saveIndexConfig(IndexConfig indexConfig) {
        if (goodsMapper.selectByPrimaryKey(indexConfig.getGoodsId()) == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        IndexConfigExample example = new IndexConfigExample();
        example.createCriteria().andConfigTypeEqualTo(indexConfig.getConfigType()).andGoodsIdEqualTo(indexConfig.getGoodsId());
        List<IndexConfig> indexConfigs = indexConfigMapper.selectByExample(example);
        IndexConfig temp = null;
        if (indexConfigs.size() > 0 && indexConfigs != null) {
            temp = indexConfigs.get(0);
        }
        if (temp != null) {
            return ServiceResultEnum.SAME_INDEX_CONFIG_EXIST.getResult();
        }
        if (indexConfigMapper.insertSelective(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 修改
     *
     * @param indexConfig
     * @return
     */
    @Override
    public String updateIndexConfig(IndexConfig indexConfig) {
        if (goodsMapper.selectByPrimaryKey(indexConfig.getGoodsId()) == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        IndexConfig temp = indexConfigMapper.selectByPrimaryKey(indexConfig.getConfigId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        IndexConfigExample example = new IndexConfigExample();
        example.createCriteria().andConfigTypeEqualTo(indexConfig.getConfigType()).andGoodsIdEqualTo(indexConfig.getGoodsId());
        List<IndexConfig> indexConfigs = indexConfigMapper.selectByExample(example);
        IndexConfig temp2 = null;
        if (indexConfigs.size() > 0 && indexConfigs != null) {
            temp2 = indexConfigs.get(0);
        }
        if (temp2 != null && !temp2.getConfigId().equals(indexConfig.getConfigId())) {
            //goodsId相同且不同id 不能继续修改
            return ServiceResultEnum.SAME_INDEX_CONFIG_EXIST.getResult();
        }
        indexConfig.setUpdateTime(new Date());
        if (indexConfigMapper.updateByPrimaryKeySelective(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }


    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteBatch(List<Long> ids) {
        if (ids.size() < 1) {
            return false;
        }
        IndexConfigExample example = new IndexConfigExample();
        example.createCriteria().andConfigIdIn(ids);
        //删除数据
        return indexConfigMapper.deleteByExample(example) > 0;
    }
}

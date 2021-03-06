package com.cyg.newbee_mall.mapper;

import com.cyg.newbee_mall.pojo.NewBeeMallGoods;
import com.cyg.newbee_mall.pojo.NewBeeMallGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewBeeMallGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int countByExample(NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int deleteByExample(NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int deleteByPrimaryKey(Long goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int insert(NewBeeMallGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int insertSelective(NewBeeMallGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    List<NewBeeMallGoods> selectByExampleWithBLOBs(NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    List<NewBeeMallGoods> selectByExample(NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    NewBeeMallGoods selectByPrimaryKey(Long goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByExampleSelective(@Param("record") NewBeeMallGoods record, @Param("example") NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") NewBeeMallGoods record, @Param("example") NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByExample(@Param("record") NewBeeMallGoods record, @Param("example") NewBeeMallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByPrimaryKeySelective(NewBeeMallGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(NewBeeMallGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_goods_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByPrimaryKey(NewBeeMallGoods record);
}
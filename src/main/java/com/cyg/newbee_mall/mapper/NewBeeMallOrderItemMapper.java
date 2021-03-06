package com.cyg.newbee_mall.mapper;

import com.cyg.newbee_mall.pojo.NewBeeMallOrderItem;
import com.cyg.newbee_mall.pojo.NewBeeMallOrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewBeeMallOrderItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int countByExample(NewBeeMallOrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int deleteByExample(NewBeeMallOrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int deleteByPrimaryKey(Long orderItemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int insert(NewBeeMallOrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int insertSelective(NewBeeMallOrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    List<NewBeeMallOrderItem> selectByExample(NewBeeMallOrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    NewBeeMallOrderItem selectByPrimaryKey(Long orderItemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByExampleSelective(@Param("record") NewBeeMallOrderItem record, @Param("example") NewBeeMallOrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByExample(@Param("record") NewBeeMallOrderItem record, @Param("example") NewBeeMallOrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByPrimaryKeySelective(NewBeeMallOrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_newbee_mall_order_item
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    int updateByPrimaryKey(NewBeeMallOrderItem record);
}
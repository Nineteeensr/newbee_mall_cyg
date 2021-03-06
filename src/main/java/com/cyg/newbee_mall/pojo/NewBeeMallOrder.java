package com.cyg.newbee_mall.pojo;

import java.util.Date;

public class NewBeeMallOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.order_id
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Long orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.order_no
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.user_id
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.total_price
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Integer totalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.pay_status
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Byte payStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.pay_type
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Byte payType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.pay_time
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.order_status
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Byte orderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.extra_info
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private String extraInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.user_name
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.user_phone
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private String userPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.user_address
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private String userAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.is_deleted
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.create_time
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_newbee_mall_order.update_time
     *
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.order_id
     *
     * @return the value of tb_newbee_mall_order.order_id
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.order_id
     *
     * @param orderId the value for tb_newbee_mall_order.order_id
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.order_no
     *
     * @return the value of tb_newbee_mall_order.order_no
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.order_no
     *
     * @param orderNo the value for tb_newbee_mall_order.order_no
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.user_id
     *
     * @return the value of tb_newbee_mall_order.user_id
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.user_id
     *
     * @param userId the value for tb_newbee_mall_order.user_id
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.total_price
     *
     * @return the value of tb_newbee_mall_order.total_price
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.total_price
     *
     * @param totalPrice the value for tb_newbee_mall_order.total_price
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.pay_status
     *
     * @return the value of tb_newbee_mall_order.pay_status
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Byte getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.pay_status
     *
     * @param payStatus the value for tb_newbee_mall_order.pay_status
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.pay_type
     *
     * @return the value of tb_newbee_mall_order.pay_type
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.pay_type
     *
     * @param payType the value for tb_newbee_mall_order.pay_type
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.pay_time
     *
     * @return the value of tb_newbee_mall_order.pay_time
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.pay_time
     *
     * @param payTime the value for tb_newbee_mall_order.pay_time
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.order_status
     *
     * @return the value of tb_newbee_mall_order.order_status
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.order_status
     *
     * @param orderStatus the value for tb_newbee_mall_order.order_status
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.extra_info
     *
     * @return the value of tb_newbee_mall_order.extra_info
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.extra_info
     *
     * @param extraInfo the value for tb_newbee_mall_order.extra_info
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.user_name
     *
     * @return the value of tb_newbee_mall_order.user_name
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.user_name
     *
     * @param userName the value for tb_newbee_mall_order.user_name
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.user_phone
     *
     * @return the value of tb_newbee_mall_order.user_phone
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.user_phone
     *
     * @param userPhone the value for tb_newbee_mall_order.user_phone
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.user_address
     *
     * @return the value of tb_newbee_mall_order.user_address
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.user_address
     *
     * @param userAddress the value for tb_newbee_mall_order.user_address
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.is_deleted
     *
     * @return the value of tb_newbee_mall_order.is_deleted
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.is_deleted
     *
     * @param isDeleted the value for tb_newbee_mall_order.is_deleted
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.create_time
     *
     * @return the value of tb_newbee_mall_order.create_time
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.create_time
     *
     * @param createTime the value for tb_newbee_mall_order.create_time
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_newbee_mall_order.update_time
     *
     * @return the value of tb_newbee_mall_order.update_time
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_newbee_mall_order.update_time
     *
     * @param updateTime the value for tb_newbee_mall_order.update_time
     * @mbggenerated Thu Dec 09 19:17:31 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
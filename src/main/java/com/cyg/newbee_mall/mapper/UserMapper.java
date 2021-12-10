package com.cyg.newbee_mall.mapper;

import com.cyg.newbee_mall.pojo.User;

import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-09-18:55
 */
public interface UserMapper {
    List<User> findUsers();
}

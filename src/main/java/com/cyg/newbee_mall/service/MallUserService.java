package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.MallUser;
import com.github.pagehelper.PageInfo;

/**
 * @author CuiYuangeng
 * @create 2021-12-09-19:43
 */
public interface MallUserService {
    PageInfo<MallUser> selectUsers(Integer pageNum, Integer pageSize);
}

package com.cyg.newbee_mall.service.impl;

import com.cyg.newbee_mall.mapper.AdminUserMapper;
import com.cyg.newbee_mall.pojo.AdminUser;
import com.cyg.newbee_mall.pojo.AdminUserExample;
import com.cyg.newbee_mall.service.AdminUserService;
import com.cyg.newbee_mall.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CuiYuangeng
 * @create 2021-12-09-10:05
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMD5 = MD5Util.MD5Encode(password, "UTF-8");
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andLoginUserNameEqualTo(userName).andLoginPasswordEqualTo(passwordMD5);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(example);
        return adminUsers.get(0);
    }
}

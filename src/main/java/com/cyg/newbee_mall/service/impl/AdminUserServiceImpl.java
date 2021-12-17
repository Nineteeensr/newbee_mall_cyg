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

    @Override
    public AdminUser getUserDetailById(Integer id) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(id);
        return adminUser;
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            if (originalPasswordMd5.equals(adminUser.getLoginPassword())) {
                adminUser.setLoginPassword(newPasswordMd5);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新名称并修改
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }
}

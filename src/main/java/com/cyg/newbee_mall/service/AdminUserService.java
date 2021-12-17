package com.cyg.newbee_mall.service;

import com.cyg.newbee_mall.pojo.AdminUser;

/**
 * @author CuiYuangeng
 * @create 2021-12-09-10:04
 */
public interface AdminUserService {
    AdminUser login(String userName, String password);

    AdminUser getUserDetailById(Integer id);

    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    boolean updateName(Integer loginUserId, String loginUserName, String nickName);
}

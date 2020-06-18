package com.yjl.travel.service;

import com.yjl.travel.domain.User;

/**
 * @author yjl
 * @create 2020-06-18-15:38
 **/
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 邮箱激活
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}

package com.yjl.travel.dao;

import com.yjl.travel.domain.User;

/**
 * @author yjl
 * @create 2020-06-18-15:36
 **/
public interface UserDao {
    /**
     * 查询用户名
     * @param username
     * @return
     */
    User findByUsername(String username);


    /**
     * 用户保存
     * @param user
     */
    void save(User user);


    /**
     *     根据激活码查找用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 修改激活码状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}

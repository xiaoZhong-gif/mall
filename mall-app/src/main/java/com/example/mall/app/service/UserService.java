package com.example.mall.app.service;

import com.example.mall.app.entity.User;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author
 * @since 2019-11-19
 */
public interface UserService extends BaseService<User> {
    User getUser(String phone);

    boolean createUser();
}

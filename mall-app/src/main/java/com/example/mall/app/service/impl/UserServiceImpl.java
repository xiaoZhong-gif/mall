package com.example.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mall.app.entity.User;
import com.example.mall.app.mapper.UserMapper;
import com.example.mall.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2019-11-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {


    @Override
    public User getUser(String phone) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getPhone, phone).last("limit 1");
        User user = this.getOne(userLambdaQueryWrapper);
        return user;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean createUser() {
        return false;
    }
}

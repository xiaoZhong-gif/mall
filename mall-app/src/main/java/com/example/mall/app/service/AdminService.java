package com.example.mall.app.service;

import com.example.mall.app.entity.Admin;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2019-11-19
 */
public interface AdminService extends BaseService<Admin> {

    Admin getAdmin(String name);
}

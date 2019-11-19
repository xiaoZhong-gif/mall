package com.example.mall.app.service.impl;

import com.example.mall.app.entity.Category;
import com.example.mall.app.mapper.CategoryMapper;
import com.example.mall.app.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-11-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements CategoryService {

}

package com.example.mall.app.service.impl;

import com.example.mall.app.entity.GoodsImage;
import com.example.mall.app.mapper.GoodsImageMapper;
import com.example.mall.app.service.GoodsImageService;
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
public class GoodsImageServiceImpl extends BaseServiceImpl<GoodsImageMapper, GoodsImage> implements GoodsImageService {

}

package com.example.mall.app.service.impl;

import com.example.mall.app.entity.Goods;
import com.example.mall.app.mapper.GoodsMapper;
import com.example.mall.app.service.GoodsService;
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
public class GoodsServiceImpl extends BaseServiceImpl<GoodsMapper, Goods> implements GoodsService {

}

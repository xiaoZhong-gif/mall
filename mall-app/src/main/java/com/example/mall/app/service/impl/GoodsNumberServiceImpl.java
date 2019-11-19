package com.example.mall.app.service.impl;

import com.example.mall.app.entity.GoodsNumber;
import com.example.mall.app.mapper.GoodsNumberMapper;
import com.example.mall.app.service.GoodsNumberService;
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
public class GoodsNumberServiceImpl extends BaseServiceImpl<GoodsNumberMapper, GoodsNumber> implements GoodsNumberService {

}

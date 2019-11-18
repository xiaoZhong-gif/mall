package com.example.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.app.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


/**
 * @param <M>
 * @param <T>
 */
@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean save(T entity) {
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveOrUpdate(T entity) {
        return super.saveOrUpdate(entity);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean remove(Wrapper<T> wrapper) {
        return super.remove(wrapper);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean updateById(T entity) {
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return super.updateBatchById(entityList, batchSize);
    }

    @Override
    public T getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public Collection<T> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @Override
    public Collection<T> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper, throwEx);
    }

    @Override
    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return super.getMap(queryWrapper);
    }

    @Override
    public int count(Wrapper<T> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public List<T> list(Wrapper<T> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper) {
        return super.listMaps(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return super.listObjs(queryWrapper, mapper);
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveBatch(Collection<T> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean update(Wrapper<T> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean updateBatchById(Collection<T> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper) {
        return super.getOne(queryWrapper);
    }


    @Override
    public int count() {
        return super.count();
    }

    @Override
    public List<T> list() {
        return super.list();
    }

    @Override
    public IPage<T> page(IPage<T> page) {
        return super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return super.listMaps();
    }

    @Override
    public List<Object> listObjs() {
        return super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return super.listObjs(mapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<T> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<T> page) {
        return super.pageMaps(page);
    }

    @Override
    public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return super.getObj(queryWrapper, mapper);
    }
}

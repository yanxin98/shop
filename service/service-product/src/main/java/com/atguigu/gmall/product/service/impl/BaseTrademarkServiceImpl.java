package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.mapper.BaseTrademarkMapper;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseTrademarkServiceImpl implements BaseTrademarkService {

    @Autowired
    private BaseTrademarkMapper baseTrademarkMapper;

    @Override
    public IPage<BaseTrademark> getBaseTrademarkPage(Page<BaseTrademark> baseTrademarkPage) {
        QueryWrapper<BaseTrademark> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        IPage<BaseTrademark> baseTrademarkIPage = baseTrademarkMapper.selectPage(baseTrademarkPage, queryWrapper);
        return baseTrademarkIPage;
    }

    @Override
    public void save(BaseTrademark baseTrademark) {
        baseTrademarkMapper.insert(baseTrademark);
    }

    @Override
    public void update(BaseTrademark baseTrademark) {
        baseTrademarkMapper.updateById(baseTrademark);
    }

    @Override
    public void remove(long id) {
        baseTrademarkMapper.deleteById(id);
    }

    @Override
    public BaseTrademark getBaseTrademarkgetById(long id) {
        BaseTrademark baseTrademark = baseTrademarkMapper.selectById(id);
        return baseTrademark;
    }

    @Override
    public List<BaseTrademark> getBaseTrademarkList() {
        List<BaseTrademark> baseTrademarkList = baseTrademarkMapper.selectList(null);
        return baseTrademarkList;
    }
}

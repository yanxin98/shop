package com.atguigu.gmall.product.service.impl;


import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.product.mapper.SpuSaleAttrMapper;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuSaleAttrServiceImpl implements SpuSaleAttrService {

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Override
    public void insert(SpuSaleAttr spuSaleAttr) {
        spuSaleAttrMapper.insert(spuSaleAttr);
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrList(long spuId) {
        return spuSaleAttrMapper.selectAttrList(spuId);
    }
}

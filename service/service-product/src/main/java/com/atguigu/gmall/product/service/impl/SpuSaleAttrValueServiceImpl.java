package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.SpuSaleAttrValue;
import com.atguigu.gmall.product.mapper.SpuSaleAttrValueMapper;
import com.atguigu.gmall.product.service.SpuSaleAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuSaleAttrValueServiceImpl implements SpuSaleAttrValueService {

    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Override
    public void insert(SpuSaleAttrValue spuSaleAttrValue) {
        spuSaleAttrValueMapper.insert(spuSaleAttrValue);
    }
}

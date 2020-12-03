package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseSaleAttr;

import java.util.List;

public interface BaseSaleAttrService {
    /**
     * 获取销售属性
     * http://api.gmall.com/admin/product/baseSaleAttrList
     * @return
     */
    List<BaseSaleAttr> getBaseSaleAttrList();
}

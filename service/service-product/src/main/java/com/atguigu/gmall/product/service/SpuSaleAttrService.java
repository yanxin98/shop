package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SpuSaleAttr;

import java.util.List;

public interface SpuSaleAttrService {
    /**
     * 添加销售属性
     * @param spuSaleAttr
     */
    void insert(SpuSaleAttr spuSaleAttr);

    /**
     * 根据spuId获取销售属性
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(long spuId);
}

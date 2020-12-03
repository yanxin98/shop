package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface SkuInfoService {
    /**
     * 添加sku
     * @param skuInfo
     * @return
     */
    void saveSkuInfo(SkuInfo skuInfo);


    IPage<SkuInfo> getSkuInfoList(Page<SkuInfo> skuInfoPage);

    /**
     * 上架
     * @param skuId
     */
    void updateSale(long skuId);

    /**
     * 下架
     * @param skuId
     */
    void cancelSale(long skuId);
}

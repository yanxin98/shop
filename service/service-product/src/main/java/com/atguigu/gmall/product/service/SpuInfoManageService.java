package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface SpuInfoManageService {
    /**
     * 进行spu的分页
     * @param spuInfoPage
     * @param spuInfo
     * @return
     */
    IPage<SpuInfo> getPageList(Page<SpuInfo> spuInfoPage, SpuInfo spuInfo);

    /**
     * 添加spu
     * http://api.gmall.com/admin/product/saveSpuInfo
     * @param spuInfo
     * @return
     */
    void saveSpuInfo(SpuInfo spuInfo);
}

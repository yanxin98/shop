package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SpuImage;

import java.util.List;

public interface SpuImageService {
    /**
     * 添加图片属性进入数据库
     * @param spuImage
     */
    void insert(SpuImage spuImage);


    /**
     * 根据spuId获取图片列表
     * @param spuId
     * @return
     */
    List<SpuImage> getSpuImageList(long spuId);
}

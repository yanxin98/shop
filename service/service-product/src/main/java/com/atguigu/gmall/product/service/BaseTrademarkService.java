package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface BaseTrademarkService {

    /**
     * 获取品牌分页列表
     * @param baseTrademarkPage
     * @return
     */
    IPage<BaseTrademark> getBaseTrademarkPage(Page<BaseTrademark> baseTrademarkPage);

    /**
     * 添加品牌
     * @param baseTrademark
     * @return
     */
    void save(BaseTrademark baseTrademark);

    /**
     * 修改品牌
     * @param baseTrademark
     * @return
     */
    void update(BaseTrademark baseTrademark);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    void remove(long id);

    /**
     * 根据Id获取品牌
     * @param id
     * @return
     */
    BaseTrademark getBaseTrademarkgetById(long id);

    /**
     * 获取品牌属性
     * http://api.gmall.com/admin/product/baseTrademark/getTrademarkList
     * @return
     */
    List<BaseTrademark> getBaseTrademarkList();
}

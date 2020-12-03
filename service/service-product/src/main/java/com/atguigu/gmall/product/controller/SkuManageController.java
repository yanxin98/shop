package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/product")
public class SkuManageController {

    @Autowired
    private SkuInfoService skuInfoService;

    /**
     * 添加sku
     * @param skuInfo
     * @return
     */
    @PostMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo) {
        skuInfoService.saveSkuInfo(skuInfo);

        return Result.ok();
    }

    /**
     * 获取sku分页列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("list/{page}/{limit}")
    public Result getSkuInfoList(@PathVariable long page,
                                 @PathVariable long limit) {

        Page<SkuInfo> skuInfoPage = new Page<>(page,limit);
        IPage<SkuInfo> skuInfoIPage = skuInfoService.getSkuInfoList(skuInfoPage);

        return Result.ok(skuInfoIPage);
    }

    /**
     * 上架
     * @param skuId
     * @return
     */
    @GetMapping("onSale/{skuId}")
    public Result onSale(@PathVariable long skuId) {
        skuInfoService.updateSale(skuId);
        return Result.ok();
    }

    /**
     * 下架
     * @param skuId
     * @return
     */
    @GetMapping("cancelSale/{skuId}")
    public Result cancelSale(@PathVariable long skuId) {
        skuInfoService.cancelSale(skuId);
        return Result.ok();
    }

}

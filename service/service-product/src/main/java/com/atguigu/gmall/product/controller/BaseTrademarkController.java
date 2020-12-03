package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/product/baseTrademark")
public class BaseTrademarkController {

    @Autowired
    private BaseTrademarkService baseTrademarkService;

    /**
     * 获取品牌分页列表
     * http://api.gmall.com/admin/product/baseTrademark/{page}/{limit}
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("{page}/{limit}")
    private Result<IPage> getPageLimit(@PathVariable long page,
                                       @PathVariable long limit) {

        Page<BaseTrademark> baseTrademarkPage = new Page<>(page, limit);

        IPage<BaseTrademark> baseTrademarkList = baseTrademarkService.getBaseTrademarkPage(baseTrademarkPage);

        return Result.ok(baseTrademarkList);
    }

    /**
     * 添加品牌
     * @param baseTrademark
     * @return
     */
    @PostMapping("save")
    public Result saveBaseTrademark(@RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.save(baseTrademark);
        return Result.ok();
    }

    /**
     * 修改品牌
     * @param baseTrademark
     * @return
     */
    @PutMapping("update")
    public Result updateBaseTrademark(@RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.update(baseTrademark);
        return Result.ok();
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @DeleteMapping("remove/{id}")
    public Result removeBaseTrademark(@PathVariable long id) {
        baseTrademarkService.remove(id);
        return Result.ok();
    }

    /**
     * 根据Id获取品牌
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<BaseTrademark> getById(@PathVariable long id) {
        BaseTrademark baseTrademark = baseTrademarkService.getBaseTrademarkgetById(id);
        return Result.ok(baseTrademark);
    }

    /**
     * 获取品牌属性
     * 1、用于品牌的显示
     * 2、用于添加 spu 时的品牌选择
     * http://api.gmall.com/admin/product/baseTrademark/getTrademarkList
     * @return
     */
    @GetMapping("/getTrademarkList")
    public Result<List<BaseTrademark>> getTrademarkList() {
        List<BaseTrademark> baseTrademarkList = baseTrademarkService.getBaseTrademarkList();
        return Result.ok(baseTrademarkList);
    }
}

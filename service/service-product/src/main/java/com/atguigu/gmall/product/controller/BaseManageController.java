package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.ManageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品基础属性接口")
@RestController
@RequestMapping("admin/product")
public class BaseManageController {
    @Autowired
    private ManageService manageService;

    /**
     * 查询所有一级分类信息
     * @return
     */
    @GetMapping("getCategory1")
    public Result<List<BaseCategory1>> getCategory1() {
        return Result.ok(manageService.getCategory1());
    }

    /**
     * 根据一级分类 id 查询二级分类信息
     * @param category1Id
     * @return
     */
    @GetMapping("getCategory2/{category1Id}")
    public Result<List<BaseCategory2>> getCategory2(@PathVariable long category1Id) {
        return Result.ok(manageService.getCategory2(category1Id));
    }

    /**
     * 根据二级分类 id 查询三级分类信息
     * @param category2Id
     * @return
     */
    @GetMapping("getCategory3/{category2Id}")
    public Result<List<BaseCategory3>> getCategory3(@PathVariable long category2Id) {
        return Result.ok(manageService.getCategory3(category2Id));
    }

    /**
     * 根据所有分类信息查询平台属性数据
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result<List<BaseAttrInfo>> attrInfoList(@PathVariable long category1Id,
                                                   @PathVariable long category2Id,
                                                   @PathVariable long category3Id) {
        return Result.ok(manageService.getAttrInfoList(category1Id,category2Id,category3Id));
    }

    /**
     * 添加平台属性
     * @param baseAttrInfo
     * @return
     */
    @PostMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        manageService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

    /**
     * 根据平台属性ID获取平台属性对象数据
     * @param attrId
     * @return
     */
    @GetMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable long attrId) {
        BaseAttrInfo baseAttrInfo = manageService.getAttrValueList(attrId);
        return Result.ok(baseAttrInfo);
    }

}

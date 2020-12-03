package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuInfoManageService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/product")
public class SpuManageController {

    @Autowired
    private SpuInfoManageService spuInfoManageService;

    @Autowired
    private SpuImageService spuimageService;

    @Autowired
    private SpuSaleAttrService spuSaleAttrService;

    /**
     * 获取spu分页列表
     * http://api.gmall.com/admin/product/ {page}/{limit}?category3Id=61
     * @param page
     * @param limit
     * @param spuInfo
     * @return
     */
    @RequestMapping("{page}/{limit}")
    public Result getPageLimit(@PathVariable long page,
                                        @PathVariable long limit,
                                        //这个地方该怎么写？
                                        //@RequestBody long SpuInfo.get
                                        //直接传入一个对象
                                        SpuInfo spuInfo) {

        //进行分页查询
        Page<SpuInfo> spuInfoPage = new Page<>(page, limit);

        //调用服务方法进行分页查询
        //此时应该返回什么值?返回一个list集合？
        //想错了返回的应该是分页信息
        IPage<SpuInfo> spuInfoIPage = spuInfoManageService.getPageList(spuInfoPage, spuInfo);

        return Result.ok(spuInfoIPage);
    }



    /**
     * 添加spu
     * http://api.gmall.com/admin/product/saveSpuInfo
     * @param spuInfo
     * @return
     */
    @PostMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo) {
        spuInfoManageService.saveSpuInfo(spuInfo);
        return Result.ok();
    }

    /**
     * 根据spuId获取图片列表
     * @param spuId
     * @return
     */
    @GetMapping("spuImageList/{spuId}")
    public Result spuImageList(@PathVariable long spuId) {
        List<SpuImage> spuImageList = spuimageService.getSpuImageList(spuId);
        return Result.ok(spuImageList);
    }

    /**
     * 根据spuId获取销售属性
     * 但是此时只是获取到对应的销售属性的信息，还需要获取销售属性值的信息
     * 需要自己编写 sql 语句
     *
     * 此处数据回显不正确版本与颜色不显示对应的属性
     *
     * sql 语句错了
     * on ssa.id=ssav.id and ssa.base_sale_attr_id=ssav.base_sale_attr_id
     * 他们两的主键 id 怎么能相等呢
     * 查看数据库的值是否正确，当数据库所有的值都对应上时就能够查询到
     * @param spuId
     * @return
     */
    @GetMapping("spuSaleAttrList/{spuId}")
    public Result spuSaleAttrList(@PathVariable long spuId) {
        List<SpuSaleAttr> spuSaleAttrList =  spuSaleAttrService.getSpuSaleAttrList(spuId);

        return Result.ok(spuSaleAttrList);
    }

}

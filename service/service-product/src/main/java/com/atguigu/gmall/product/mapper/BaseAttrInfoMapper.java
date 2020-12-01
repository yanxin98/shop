package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {
    /**
     * 根据分类Id 查询平台属性集合对象 | 编写xml 文件
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> selectBaseAttrInfoList(@Param("category1Id") long category1Id,
                                              @Param("category2Id") long category2Id,
                                              @Param("category3Id") long category3Id);
}

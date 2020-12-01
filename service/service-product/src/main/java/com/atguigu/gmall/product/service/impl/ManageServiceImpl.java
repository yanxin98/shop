package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.mapper.*;
import com.atguigu.gmall.product.service.ManageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper;

    @Autowired
    private BaseCategory2Mapper baseCategory2Mapper;

    @Autowired
    private BaseCategory3Mapper baseCategory3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseCategory1> getCategory1() {
        List<BaseCategory1> baseCategory1List = baseCategory1Mapper.selectList(null);
        return baseCategory1List;
    }

    @Override
    public List<BaseCategory2> getCategory2(long category1Id) {
        return baseCategory2Mapper.selectList(new QueryWrapper<BaseCategory2>().eq("category1_id", category1Id));
    }

    @Override
    public List<BaseCategory3> getCategory3(long category2Id) {
        return baseCategory3Mapper.selectList(new QueryWrapper<BaseCategory3>().eq("category2_id", category2Id));
    }

    @Override
    public List<BaseAttrInfo> getAttrInfoList(long category1Id, long category2Id, long category3Id) {
        return baseAttrInfoMapper.selectBaseAttrInfoList(category1Id, category2Id, category3Id);
    }

    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //保存和添加写道一个方法中进行判断通过获取对应的id是否为空
        if (baseAttrInfo.getId() == null) { //为空添加
            baseAttrInfoMapper.insert(baseAttrInfo);
        }else { //不为空就修改
            baseAttrInfoMapper.updateById(baseAttrInfo);
        }

        //当修改时先或取对应的value的父类id值进行删除
        QueryWrapper<BaseAttrValue> baseAttrValueQueryWrapper = new QueryWrapper<>();
        baseAttrValueQueryWrapper.eq("attr_id",baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValueQueryWrapper);

        //int insert = baseAttrInfoMapper.insert(baseAttrInfo);
        //就上面一个语句就只会加上一个info的信息，不会加value信息，通过传入的信息获取信息里面的value信息
        //把 value 的信息遍历出来存储到对应的数据库中
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        if (!CollectionUtils.isEmpty(attrValueList)) { //当获取的value集合不为空时进行遍历，避免空指针异常
            for (BaseAttrValue baseAttrValue : attrValueList) {
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }

    }

    @Override
    public BaseAttrInfo getAttrValueList(long attrId) {
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectById(attrId);
        if (baseAttrInfo!=null) {
            Long id = baseAttrInfo.getId();
            baseAttrInfo.setAttrValueList(baseAttrValueMapper.selectList(new QueryWrapper<BaseAttrValue>().eq("attr_id", id)));
        }
        return baseAttrInfo;
    }
}

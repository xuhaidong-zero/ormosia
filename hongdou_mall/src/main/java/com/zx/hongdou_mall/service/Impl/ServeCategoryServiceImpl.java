package com.zx.hongdou_mall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.dao.ServeCategoryMapper;
import com.zx.hongdou_mall.entity.ServeCategory;
import com.zx.hongdou_mall.service.ServeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeCategoryServiceImpl implements ServeCategoryService {

    @Autowired
    private ServeCategoryMapper serveCategoryMapper;
    @Override
    public ServeCategory selectOne(Long id) {
        return serveCategoryMapper.selectOne(id);
    }

    @Override
    public int createOne(ServeCategory serveCategory) {
        return serveCategoryMapper.createOne(serveCategory);
    }

    @Override
    public int updateOne(ServeCategory serveCategory) {
        return serveCategoryMapper.updateOne(serveCategory);
    }

    @Override
    public int deleteOne(Long id) {
        return serveCategoryMapper.deleteOne(id);
    }

    @Override
    public PageResult findAll(Integer page, Integer size) {
        PageInfo<ServeCategory> pageInfo=
                PageHelper.startPage(page,size).doSelectPageInfo(()-> serveCategoryMapper.findAll());
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}

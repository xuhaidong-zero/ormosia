package com.zx.hongdou_mall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.dao.IntroduceMapper;
import com.zx.hongdou_mall.entity.Introduce;
import com.zx.hongdou_mall.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntroduceServiceImpl implements IntroduceService {

    @Autowired
    private IntroduceMapper introduceMapper;
    @Override
    public Introduce selectOne(Long id) {
        return introduceMapper.selectOne(id);
    }

    @Override
    public int createOne(Introduce introduce) {
        return introduceMapper.createOne(introduce);
    }

    @Override
    public int updateOne(Introduce introduce) {
        return introduceMapper.updateOne(introduce);
    }

    @Override
    public int deleteOne(Long id) {
        return introduceMapper.deleteOne(id);
    }

    @Override
    public PageResult findAll(Integer page, Integer size) {
        PageInfo<Introduce> pageInfo=
                PageHelper.startPage(page,size).doSelectPageInfo(()->introduceMapper.findAll());
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}

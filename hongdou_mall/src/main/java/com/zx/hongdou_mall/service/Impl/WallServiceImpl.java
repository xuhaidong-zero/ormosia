package com.zx.hongdou_mall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.dao.WallMapper;
import com.zx.hongdou_mall.entity.Wall;
import com.zx.hongdou_mall.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WallServiceImpl implements WallService {

    @Autowired
    private WallMapper wallMapper;
    @Override
    public Wall selectOne(Long id) {
        return wallMapper.selectOne(id);
    }

    @Override
    public int createOne(Wall wall) {
        return wallMapper.createOne(wall);
    }

    @Override
    public int updateOne(Wall wall) {
        return wallMapper.updateOne(wall);
    }

    @Override
    public int deleteOne(Long id) {
        return wallMapper.deleteOne(id);
    }

    @Override
    public PageResult findAll(Integer page, Integer size) {
        PageInfo<Wall> pageInfo=
                PageHelper.startPage(page,size).doSelectPageInfo(()->wallMapper.findAll());
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}

package com.zx.hongdou_mall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.dao.VideoMapper;
import com.zx.hongdou_mall.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.hongdou_mall.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Video selectOne(Long id) {
        return videoMapper.selectOne(id);
    }

    @Override
    public int createOne(Video video) {
        return videoMapper.createOne(video);
    }

    @Override
    public int updateOne(Video video) {
        return videoMapper.updateOne(video);
    }

    @Override
    public int deleteOne(Long id) {
        return videoMapper.deleteOne(id);
    }

    @Override
    public PageResult findAll(Integer page, Integer size) {
        PageInfo<Video> pageInfo=
                PageHelper.startPage(page,size).doSelectPageInfo(()->videoMapper.findAll());
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }
}

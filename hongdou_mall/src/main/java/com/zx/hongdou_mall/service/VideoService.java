package com.zx.hongdou_mall.service;

import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.entity.Video;

public interface VideoService {


    Video selectOne(Long id);

    int createOne(Video video);

    int updateOne(Video video);

    int deleteOne(Long id);

    PageResult findAll(Integer page, Integer size);
}

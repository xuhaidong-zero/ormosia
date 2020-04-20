package com.zx.hongdou_mall.service;

import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.entity.Wall;

public interface WallService {


    Wall selectOne(Long id);

    int createOne(Wall wall);

    int updateOne(Wall wall);

    int deleteOne(Long id);

    PageResult findAll(Integer page, Integer size);
}

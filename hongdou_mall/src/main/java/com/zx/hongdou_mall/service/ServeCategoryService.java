package com.zx.hongdou_mall.service;

import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.entity.ServeCategory;

public interface ServeCategoryService {


    ServeCategory selectOne(Long id);

    int createOne(ServeCategory serviceCategory);

    int updateOne(ServeCategory serviceCategory);

    int deleteOne(Long id);

    PageResult findAll(Integer page, Integer size);
}

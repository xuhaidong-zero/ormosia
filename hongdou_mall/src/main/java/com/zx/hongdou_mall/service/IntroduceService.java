package com.zx.hongdou_mall.service;

import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.entity.Introduce;

public interface IntroduceService {


    Introduce selectOne(Long id);

    int createOne(Introduce introduce);

    int updateOne(Introduce introduce);

    int deleteOne(Long id);

    PageResult findAll(Integer page, Integer size);
}

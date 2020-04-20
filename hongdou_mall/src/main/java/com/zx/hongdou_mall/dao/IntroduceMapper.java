package com.zx.hongdou_mall.dao;

import com.zx.hongdou_mall.entity.Introduce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IntroduceMapper {
    Introduce selectOne(@Param("id") Long id);

    int createOne(@Param("introduce") Introduce introduce);

    int updateOne(@Param("introduce") Introduce introduce);

    int deleteOne(@Param("id") Long id);

    List<Introduce> findAll();
}
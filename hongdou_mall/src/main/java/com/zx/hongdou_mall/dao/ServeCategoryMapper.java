package com.zx.hongdou_mall.dao;

import com.zx.hongdou_mall.entity.ServeCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServeCategoryMapper {
    ServeCategory selectOne(@Param("id") Long id);

    int createOne(@Param("serveCategory") ServeCategory serveCategory);

    int updateOne(@Param("serveCategory") ServeCategory serveCategory);

    int deleteOne(@Param("id") Long id);

    List<ServeCategory> findAll();
}
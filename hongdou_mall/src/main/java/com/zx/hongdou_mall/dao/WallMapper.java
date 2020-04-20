package com.zx.hongdou_mall.dao;

import com.zx.hongdou_mall.entity.Wall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WallMapper {
    Wall selectOne(@Param("id") Long id);

    int createOne(@Param("wall") Wall wall);

    int updateOne(@Param("wall") Wall wall);

    int deleteOne(@Param("id") Long id);

    List<Wall> findAll();
}
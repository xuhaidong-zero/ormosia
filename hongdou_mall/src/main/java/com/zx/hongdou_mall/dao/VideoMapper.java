package com.zx.hongdou_mall.dao;

import com.zx.hongdou_mall.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface VideoMapper {
    Video selectOne(@Param("id") Long id);

    int createOne(@Param("video") Video video);

    int updateOne(@Param("video") Video video);

    int deleteOne(@Param("id") Long id);

    List<Video> findAll();
}
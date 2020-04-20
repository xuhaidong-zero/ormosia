package com.zx.hongdou_mall.controller;


import com.zx.hongdou_mall.common.CodeNum;
import com.zx.hongdou_mall.common.MessageConst;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.common.Result;
import com.zx.hongdou_mall.entity.Video;
import com.zx.hongdou_mall.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName VideoController
 * @Description: TODO
 * @Author haidong
 * @Date 2020/4/18
 * @Version V1.0
 **/
@RestController
@RequestMapping("user/video")
@Api(value = "视频controller", tags = {"视频操作接口"})
public class VideoController {

    @Autowired
    private VideoService videoService;


    /**
     * 查询一条结果
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "查询一条记录")
    @ApiParam(name = ("id"), defaultValue = "视频的id")

    public Result selectOn(Long id) {
        if (id == null || "".equals(id)) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        Video video = videoService.selectOne(id);
        if (video != null) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_SUCCESS, video);

        } else {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.ACTION_FAIL, null);
        }
    }

    /**
     * 添加一条数据
     */
    @PostMapping("createOne")
    public Result createOne(@RequestBody Video video) {
        System.out.println(video);

        if (video.getImage() == null || video.getImage() == "") {
            return new Result(CodeNum.PARAM_NULL, "视频不能为空", null);
        }
        int i = videoService.createOne(video);
        if (i > 0) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.ADD_SUCCESS, null);
        } else {
            return new Result(CodeNum.QUERY_FAIL, MessageConst.ADD_FAIL, null);
        }
    }

    /**
     * 修改一条数据
     */
    @PostMapping("updateOne")
    private Result updateOne(@RequestBody Video video) {
        if (video.getId() == null || "".equals(video.getId())) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        int i = videoService.updateOne(video);
        if (i > 0) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.EDIT_SUCCESS, null);
        } else {
            return new Result(CodeNum.QUERY_FAIL, MessageConst.EDIT_FAIL, null);
        }
    }

    /**
     * 删除一条数据
     */
    @PostMapping("deleteOne")
    private Result deleteOne(Long id) {
        if (id == null || "".equals(id)) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        int i = videoService.deleteOne(id);
        if (i > 0) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.DELETE_SUCCESS, null);
        } else {
            return new Result(CodeNum.QUERY_FAIL, MessageConst.DELETE_FAIL, null);
        }
    }

    /**
     * 查询类表
     */
    @GetMapping("findAll")
    public Result findAll(Integer page, Integer size) {
        if (page == null || "".equals(page)) {
            return new Result(CodeNum.PARAM_NULL, "当前页不能为空", null);
        }
        if (size == null || "".equals(size)) {
            return new Result(CodeNum.PARAM_NULL, "每页条数不能为空", null);
        }
        PageResult pageResult = videoService.findAll(page, size);
        if (pageResult != null) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_SUCCESS, pageResult);
        } else {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_FAIL, null);
        }


    }

}

package com.zx.hongdou_mall.controller;


import com.zx.hongdou_mall.common.CodeNum;
import com.zx.hongdou_mall.common.MessageConst;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.common.Result;
import com.zx.hongdou_mall.entity.Wall;
import com.zx.hongdou_mall.service.WallService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName WallController
 * @Description: TODO
 * @Author haidong
 * @Date 2020/4/18
 * @Version V1.0
 **/
@RestController
@RequestMapping("user/wall")
public class WallController {

    @Autowired
    private WallService wallService;


    /**
     * 查询一条结果
     */
    @GetMapping("selectOne")
    public Result selectOn(Long id) {
        if (id == null || "".equals(id)) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        Wall wall = wallService.selectOne(id);
        if (wall != null) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_SUCCESS, wall);

        } else {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.ACTION_FAIL, null);
        }
    }

    /**
     * 添加一条数据
     */
    @PostMapping("createOne")
    public Result createOne(@RequestBody Wall wall) {
        int i = wallService.createOne(wall);
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
    private Result updateOne(@RequestBody Wall wall) {
        if (wall.getId() == null || "".equals(wall.getId())) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        int i = wallService.updateOne(wall);
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
        int i = wallService.deleteOne(id);
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
        PageResult pageResult = wallService.findAll(page, size);
        if (pageResult != null) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_SUCCESS, pageResult);
        } else {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_FAIL, null);
        }


    }

}

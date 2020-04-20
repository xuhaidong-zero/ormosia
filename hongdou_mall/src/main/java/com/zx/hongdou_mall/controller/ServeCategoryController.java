package com.zx.hongdou_mall.controller;


import com.zx.hongdou_mall.common.CodeNum;
import com.zx.hongdou_mall.common.MessageConst;
import com.zx.hongdou_mall.common.PageResult;
import com.zx.hongdou_mall.common.Result;
import com.zx.hongdou_mall.entity.ServeCategory;
import com.zx.hongdou_mall.service.ServeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ServiceCategoryController
 * @Description: TODO
 * @Author haidong
 * @Date 2020/4/18
 * @Version V1.0
 **/
@RestController
@RequestMapping("user/serveCategory")
public class ServeCategoryController {

    @Autowired
    private ServeCategoryService serveCategoryService;


    /**
     * 查询一条结果
     */
    @GetMapping("selectOne")
    public Result selectOn(Long id) {
        if (id == null || "".equals(id)) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        ServeCategory serviceCategory = serveCategoryService.selectOne(id);
        if (serviceCategory != null) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_SUCCESS, serviceCategory);

        } else {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.ACTION_FAIL, null);
        }
    }

    /**
     * 添加一条数据
     */
    @PostMapping("createOne")
    public Result createOne(@RequestBody ServeCategory serveCategory) {
        int i = serveCategoryService.createOne(serveCategory);
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
    private Result updateOne(@RequestBody ServeCategory serveCategory) {
        if (serveCategory.getId() == null || "".equals(serveCategory.getId())) {
            return new Result(CodeNum.PARAM_NULL, "id不能为空", null);
        }
        int i = serveCategoryService.updateOne(serveCategory);
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
        int i = serveCategoryService.deleteOne(id);
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
        PageResult pageResult = serveCategoryService.findAll(page, size);
        if (pageResult != null) {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_SUCCESS, pageResult);
        } else {
            return new Result(CodeNum.QUERY_SUCCESS, MessageConst.QUERY_FAIL, null);
        }


    }

}

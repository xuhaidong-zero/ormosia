package com.zx.hongdou_mall.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageResult 封装分页查询结果
 * @Description: TODO
 * @Author haidong
 * @Date 2020/1/15
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
public class PageResult implements Serializable {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 当前页结果
     */
    private List rows;
    public PageResult(Long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
}

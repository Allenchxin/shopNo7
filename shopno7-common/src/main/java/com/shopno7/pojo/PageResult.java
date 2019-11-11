package com.shopno7.pojo;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description 分页结果
 * @Author Allen·Chen
 * @Date 2019/11/11 21:57
 * @Version 1.0
 */
public class PageResult<T> {

    private Long total;//总条数
    private Integer totalPage;//总页数
    private List<T> items;//当前页面数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

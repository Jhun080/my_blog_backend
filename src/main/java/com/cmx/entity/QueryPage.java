package com.cmx.entity;

import java.io.Serializable;

public class QueryPage implements Serializable {
    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数
    private String query;//查询条件

    public QueryPage() {
    }

    @Override
    public String toString() {
        return "QueryPage{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", query='" + query + '\'' +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public QueryPage(Integer currentPage, Integer pageSize, String query) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.query = query;
    }
}
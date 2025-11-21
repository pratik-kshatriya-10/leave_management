package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.utils.Constants;

public class PaginationDto {

    private int limit;

    private int offset;

    private String searchStr;

    private String defaultSortColumn;

    private String defaultSortType;

    public int getLimit() {
        if (limit == 0) {
           return Constants.DEFAULT_LIMIT;
        }
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public String getDefaultSortColumn() {
        return defaultSortColumn;
    }

    public void setDefaultSortColumn(String defaultSortColumn) {
        this.defaultSortColumn = defaultSortColumn;
    }

    public String getDefaultSortType() {
        return defaultSortType;
    }

    public void setDefaultSortType(String defaultSortType) {
        this.defaultSortType = defaultSortType;
    }
}

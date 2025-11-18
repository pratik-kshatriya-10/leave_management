package com.pheonix.leavemanagement.models;

import com.pheonix.leavemanagement.dtos.PaginationDto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class DataGridModel<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 2443293680753283643L;

    private transient List<T> data;
    private int count;
    private transient PaginationDto paginationDto;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PaginationDto getPaginationDto() {
        return paginationDto;
    }

    public void setPaginationDto(PaginationDto paginationDto) {
        this.paginationDto = paginationDto;
    }
}

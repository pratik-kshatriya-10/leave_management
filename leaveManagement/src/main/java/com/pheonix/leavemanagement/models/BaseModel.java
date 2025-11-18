package com.pheonix.leavemanagement.models;

import java.io.Serial;
import java.io.Serializable;

public class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 2711151626167381585L;

    private long createdAt;
    private String createdBy;
    private long updatedAt;
    private String updatedBy;
    private boolean deletedAt;

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(boolean deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void updateCCUU(String userId, long now){
        this.createdAt = now;
        this.createdBy = userId;
        this.updatedAt = now;
        this.updatedBy = userId;
        this.deletedAt = false;
    }

    public void updateUU(String userId, long now){
        this.updatedAt = now;
        this.updatedBy = userId;
    }

    public void updateUUD(String userId, long now){
        this.updatedAt = now;
        this.updatedBy = userId;
        this.deletedAt = true;
    }

}

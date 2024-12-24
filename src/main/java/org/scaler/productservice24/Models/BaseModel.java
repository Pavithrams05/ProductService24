package org.scaler.productservice24.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {

    private Long id;
    private Long createdAt;
    private Long lastUpdateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLastUpdateAt() {
        return lastUpdateAt;
    }
    public void setLastUpdateAt(Long lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }
}

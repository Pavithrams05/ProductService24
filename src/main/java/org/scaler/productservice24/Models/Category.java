package org.scaler.productservice24.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel{

    private String value;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}

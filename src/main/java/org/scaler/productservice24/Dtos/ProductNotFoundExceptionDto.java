package org.scaler.productservice24.Dtos;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class ProductNotFoundExceptionDto {

    private String message;
    private String resolution;

    public String getMessage(){
        return this.message;

    }

    public String getResolution(){
        return this.resolution;
    }

    public void setMessage(String message){
        this.message=message;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}

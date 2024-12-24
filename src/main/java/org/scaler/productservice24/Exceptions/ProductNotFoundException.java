package org.scaler.productservice24.Exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(long productId, String message){

        super(message+" id= "+productId);
    }
}

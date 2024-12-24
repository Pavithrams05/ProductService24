package org.scaler.productservice24.ControllerAdvices;


import org.scaler.productservice24.Dtos.ProductNotFoundExceptionDto;
import org.scaler.productservice24.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException() {
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage("product not found with given id");
        dto.setResolution("pass a valid id");
        return new ResponseEntity<>(dto,
                HttpStatus.NOT_FOUND);
    }

    //message from the service can be directly written to the dto
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception) {
//        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
//        dto.setMessage(exception.getMessage());
//        dto.setResolution("try with a valid id");
//        return new ResponseEntity<>(dto,
//                HttpStatus.NOT_FOUND);
//    }
}

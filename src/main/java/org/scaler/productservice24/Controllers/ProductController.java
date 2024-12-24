package org.scaler.productservice24.Controllers;

import org.scaler.productservice24.Dtos.ProductNotFoundExceptionDto;
import org.scaler.productservice24.Exceptions.ProductNotFoundException;
import org.scaler.productservice24.Models.Product;
import org.scaler.productservice24.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //adding Response entity/API o a methods
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {

//        try{
//            return new ResponseEntity<>(
//                    productService.getSingleProduct(id),
//                    HttpStatus.OK);
//        }catch (RuntimeException e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK);


    }

    @GetMapping
    public List<Product> getAllProducts(){


        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public boolean deleteProdct(@PathVariable("id") Long id){
        return true;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }


    @PutMapping("{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    //handle the exceptions locally instead of global exception handler
    //message from the service can be directly written to the dto
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception) {
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage(exception.getMessage());
        dto.setResolution("try with a valid id");
        return new ResponseEntity<>(dto,
                HttpStatus.NOT_FOUND);
    }
}

package org.scaler.productservice24.Services;



import org.scaler.productservice24.Exceptions.ProductNotFoundException;
import org.scaler.productservice24.Models.Product;

import java.util.List;

public interface ProductService {


    Product getSingleProduct(Long productId) throws ProductNotFoundException, ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    void deleteProduct(Long productId);

    Product updateProduct(Long productId, Product product);

    Product replaceProduct(Long productId, Product product);


}

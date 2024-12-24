package org.scaler.productservice24.Services;

import org.scaler.productservice24.Dtos.FakeStoreProductDto;
import org.scaler.productservice24.Exceptions.ProductNotFoundException;
import org.scaler.productservice24.Models.Category;
import org.scaler.productservice24.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        throw new ProductNotFoundException(productId,"Product not found");
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);
//        return convertFakestoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {

        //used type erasure property i.e in the response body the generic type of return to object is used
        //List<FakeStoreProductDto>.class will provide an error so used List.class error while returning

//        List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject(
//                "https://fakestoreapi.com/products", List.class);

        //using a simple hack as Arrays instead of List bz need a class of particular list not just a generic List.class

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            System.out.println("print================="+fakeStoreProductDto);
            products.add(convertFakestoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    private Product convertFakestoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        //removed lombok getter and setter for models not working while compiling the code
        Product product = new Product();
        product.setCategory(new Category());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setId(fakeStoreProductDto.getId());
        product.getCategory().setValue(fakeStoreProductDto.getCategory());
        return product;
    }
}

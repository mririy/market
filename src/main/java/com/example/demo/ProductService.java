package com.example.demo;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void processAndStoreProducts(String data) {
        String[] productsData = data.split(",");
        Product product = new Product();
        product.setProductNumber(productsData[0].trim());
        product.setName(productsData[1].trim());
        product.setPrice(new BigDecimal(productsData[2].trim()));
        product.setCurrency(productsData[3].trim());
        product.setQuantity(productsData[4].trim());
        product.setCategory(productsData[5].trim());
        product.setDescription(productsData[6].trim());
        product.setDiscount(Boolean.parseBoolean(productsData[7].trim()));
        productRepository.save(product);
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
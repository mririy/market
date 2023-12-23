package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        logger.info("Adding product: {}", product);
        try {
            productService.saveProduct(product);
            logger.info("Product added successfully");
        } catch (Exception e) {
            logger.error("Error adding product: ", e);
            return "error"; // Перенаправление на страницу ошибки
        }
        return "redirect:/admin"; // Перенаправление обратно на страницу администратора
    }
    @GetMapping("/products")
    public ResponseEntity<String> productsPage() {
        logger.info("Products page accessed");
        List<Product> products = productService.getAllProducts();

        StringBuilder htmlContent = new StringBuilder("<!DOCTYPE html>\n<html>\n<head>\n<title>Product List</title>\n</head>\n<body>\n<h1>Product List</h1>\n<ul>\n");
        for (Product product : products) {
            htmlContent.append("<li>")
                       .append("Product Name: ").append(product.getName())
                       .append(", Price: ").append(product.getPrice())
                       .append(" ").append(product.getCurrency())
                       .append("</li>\n");
        }
        htmlContent.append("</ul>\n</body>\n</html>");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlContent.toString());
    }
}
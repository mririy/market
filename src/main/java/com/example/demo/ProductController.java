package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}

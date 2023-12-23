package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/admin")
    public ResponseEntity<String> adminPage() {
        logger.info("Admin page accessed");
        String htmlContent = "<!DOCTYPE html>\n" +
        "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <title>Admin Panel</title>\n" +
        "    <!-- Здесь можно добавить стили или ссылки на CSS -->\n" +
        "</head>\n" +
        "<body>\n" +
        "    <h1>Admin Panel</h1>\n" +
        "\n" +
        "    <!-- Форма для загрузки файла -->\n" +
        "    <form th:action=\"@{/upload}\" method=\"post\" enctype=\"multipart/form-data\">\n" +
        "        <label for=\"file\">Choose file to upload</label>\n" +
        "        <input type=\"file\" id=\"file\" name=\"file\" accept=\"image/*\">\n" +
        "        <button type=\"submit\">Upload</button>\n" +
        "    </form>\n" +
        "\n" +
        "    <!-- Форма для добавления продукта -->\n" +
        "    <form action=\"/addProduct\" method=\"post\">\n" +
        "        Product Number: <input type=\"text\" name=\"productNumber\"><br>\n" +
        "        Name: <input type=\"text\" name=\"name\"><br>\n" +
        "        Price: <input type=\"text\" name=\"price\"><br>\n" +
        "        Currency: <input type=\"text\" name=\"currency\"><br>\n" +
        "        Quantity: <input type=\"text\" name=\"quantity\"><br>\n" +
        "        Category: <input type=\"text\" name=\"category\"><br>\n" +
        "        Description: <textarea name=\"description\"></textarea><br>\n" +
        "        Discount: <input type=\"checkbox\" name=\"discount\"><br>\n" +
        "        <button type=\"submit\">Add Product</button>\n" +
        "    </form>\n" +
        "\n" +
        "    <!-- Здесь можно добавить дополнительные административные функции -->\n" +
        "\n" +
        "</body>\n" +
        "</html>";
    
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlContent);
    }
}
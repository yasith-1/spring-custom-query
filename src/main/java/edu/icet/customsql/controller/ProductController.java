package edu.icet.customsql.controller;

import edu.icet.customsql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @GetMapping("/products")
    public HashMap<String, Object> getProducts() {
        return productService.getProducts();
    }
}

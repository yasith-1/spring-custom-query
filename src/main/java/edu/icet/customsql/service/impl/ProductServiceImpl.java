package edu.icet.customsql.service.impl;

import edu.icet.customsql.repository.ProductRepository;
import edu.icet.customsql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    @Override
    public HashMap<String, Object> getProducts() {
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("count", productRepository.getAllProductsCount());
        productMap.put("products", productRepository.getAllProducts());

        return productMap;
    }
}

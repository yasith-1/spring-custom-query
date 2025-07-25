package edu.icet.customsql.repository;

import edu.icet.customsql.model.Product;

import java.util.List;

public interface ProductRepository {
    Long getAllProductsCount();
    List<Product> getAllProducts();
}

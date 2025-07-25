package edu.icet.customsql.repository.impl;

import edu.icet.customsql.mapper.ProductRowMapper;
import edu.icet.customsql.model.Product;
import edu.icet.customsql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    final JdbcTemplate jdbcTemplate;

    @Override
    public Long getAllProductsCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `product`", Long.class);
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM product",new ProductRowMapper());
    }
}

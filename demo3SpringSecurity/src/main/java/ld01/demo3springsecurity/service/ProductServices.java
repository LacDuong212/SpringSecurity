package ld01.demo3springsecurity.service;

import ld01.demo3springsecurity.entity.Product;

import java.util.List;

public interface ProductServices {
    void delete(Long id);
    Product get(Long id);
    Product save(Product product);
    List<Product> getAll();
}

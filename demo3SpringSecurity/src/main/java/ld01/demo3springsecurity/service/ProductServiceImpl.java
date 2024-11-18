package ld01.demo3springsecurity.service;

import ld01.demo3springsecurity.entity.Product;
import ld01.demo3springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices{
    @Autowired
    private ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo= repo;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Product get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }
}

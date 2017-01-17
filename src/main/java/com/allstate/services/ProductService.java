package com.allstate.services;

import com.allstate.entities.Product;
import com.allstate.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public void setProductRepo(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Autowired
    IProductRepository productRepo;

    public Product create(Product p) {
        return  this.productRepo.save(p);
    }

    public Product update(Product p) {
        return  this.productRepo.save(p);
    }

    public Product readByName(String name) {
        return  this.productRepo.findOne(name);
    }

    public Iterable<Product> readAll() {
        return this.productRepo.findAll();
    }

    public void delete(String name) {
        this.productRepo.delete(name);
    }

    public Product readByCode(String code){
        return this.productRepo.findByCode(code);
    }

    public Iterable<Product> readRestrictedProducts(){
        return this.productRepo.findByRestrictedTrue();
    }



}

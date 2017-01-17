package com.allstate.repositories;

import com.allstate.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface IProductRepository extends CrudRepository<Product, String> {
    public Product findByCode(String code);

    public Iterable<Product> findByRestrictedTrue();

}

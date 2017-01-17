package com.allstate.services;

import com.allstate.entities.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class ProductServiceTest {
    public void setService(ProductService service) {
        this.service = service;
    }

    @Autowired
    ProductService service;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateProduct() throws Exception {
        Product p = new Product();
        p.setName("Television");
        p.setCode("AXXXXX");
        p.setDescription("unknown");
        p.setActual_price(22.1f);
        p.setDiscount(10);
        p.setList_price(10.1f);
        p.setQuantity(10);
        p.setRating(5);

        Product dbProduct = this.service.create(p);
        assertEquals("Television",dbProduct.getName());

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotCreateProductWhenNoProductCodeGiven() throws Exception {
        Product p = new Product();
        p.setName("DVD Player");
        p.setDescription("unknown");
        p.setActual_price(22.1f);
        p.setDiscount(10);
        p.setList_price(10.1f);
        p.setQuantity(10);
        p.setRating(5);

        Product dbProduct = this.service.create(p);
        assertEquals("DVD Player",dbProduct.getName());

    }

    @Test
    public void shouldFetchProductsByName() {
        assertEquals("DVD Player",this.service.readByName("DVD Player").getName());
    }

    @Test
    public void shouldNotFetchProductsByInvalidName() {
        assertNull(this.service.readByName("Headphones"));
    }

    @Test
    public void shouldFetchAllProducts() {
        ArrayList<Product> list = (ArrayList<Product>) this.service.readAll();
        assertEquals(1,list.size());
    }

    @Test
    public void shouldDeleteProductByName() {
        this.service.delete("DVD Player");
        assertNull(this.service.readByName("DVD Player"));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldDeleteProductByNameFails() {
        this.service.delete("DVD Player1");
        //assertNull(this.service.readByName("DVD Player"));
    }

    @Test
    public void shouldFetchProductsByCode() {
        assertEquals("DVD Player",this.service.readByCode("007").getName());
    }

    @Test
    public void shouldNotFetchProductsByInvalidCode() {
        assertNull(this.service.readByCode("007x"));
    }

    @Test
    public void shouldFetchAllRestrictedProducts() {
        ArrayList<Product> list = (ArrayList<Product>) this.service.readRestrictedProducts();
        assertEquals(1,list.size());
    }





}
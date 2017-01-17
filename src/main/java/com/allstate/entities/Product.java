package com.allstate.entities;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {

    private String name;
    private String code;
    private String description;
    private int rating;
    private int reviews;
    private float list_price;
    private int discount;
    private float actual_price;
    private int quantity;
    private boolean restricted;

    @Id
    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false,unique = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

}

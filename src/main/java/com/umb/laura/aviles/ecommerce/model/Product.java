package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private String description;
    private String gender;
    private Integer price;
    private Integer categoryId;
    private Integer price;
}

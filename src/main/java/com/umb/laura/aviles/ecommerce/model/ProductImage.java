package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImage {
    private Integer id;
    private String name;
    private String image;
    private Integer productId;
}
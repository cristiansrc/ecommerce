package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductShopping extends Product {
    private String genderName;
    private String categoryName;
    private List<ProductImage> productImages;
}

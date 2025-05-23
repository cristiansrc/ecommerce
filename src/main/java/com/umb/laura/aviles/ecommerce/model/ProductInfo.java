package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductInfo extends Product {
    private String category;
    private List<ProductColor> productColors;
    private List<ProductSize> productSizes;
    private List<ProductCharacteristics> productCharacteristics;
    private List<ProductImage> productImages;
}

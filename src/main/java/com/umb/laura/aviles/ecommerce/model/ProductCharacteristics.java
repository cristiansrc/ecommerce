package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCharacteristics {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer colorId;
    private Integer sizeId;
    private Integer productId;
}

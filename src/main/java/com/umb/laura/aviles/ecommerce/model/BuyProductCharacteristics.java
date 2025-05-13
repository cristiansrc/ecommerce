package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyProductCharacteristics {
    private Integer id;
    private Double price;
    private Integer items;
    private String color;
    private String size;
    private String colorHexa;
    private Integer buyProductId;
    private String image;
}

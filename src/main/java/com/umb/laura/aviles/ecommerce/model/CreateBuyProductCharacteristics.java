package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBuyProductCharacteristics {
    private String id;
    private Double price;
    private Integer items;
    private String color;
    private Integer size;
    private String colorHexa;
    private Integer buyProductId;
}

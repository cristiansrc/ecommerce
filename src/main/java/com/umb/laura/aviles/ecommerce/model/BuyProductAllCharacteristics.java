package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyProductAllCharacteristics {
    private Integer id;
    private Integer buyProductCharacteristicsId;
    private Integer name;
    private Double price;
    private Integer items;
    private String color;
    private String size;
    private String image;
    private String colorHexa;
}

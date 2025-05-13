package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListInfo {
    private Integer id;
    private String name;
    private String image;
    private Double minPrice;
    private Double maxPrice;
}

package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductColor {
    private Integer id;
    private String name;
    private String hex;
    private List<ProductCharacteristicsImage> productCharacteristicsImages;
}

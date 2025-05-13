package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FiltersProductIn {
    private String gender;
    private List<Integer> categoryIds;
    private List<Integer> colorIds;
    private List<Integer> sizeIds;
    private Double minPrice;
    private Double maxPrice;
}

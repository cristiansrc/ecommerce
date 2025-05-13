package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGeneric {
    private Integer code = 200;
    private String detail = "";
}

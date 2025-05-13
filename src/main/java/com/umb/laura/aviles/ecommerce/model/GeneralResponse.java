package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class GeneralResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private T data;
    private ResponseGeneric responseInfo = new ResponseGeneric();
}

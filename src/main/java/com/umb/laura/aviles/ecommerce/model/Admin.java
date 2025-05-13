package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private Integer id;
    private String name;
    private String lastName;
    private String mail;
    private String password;
}

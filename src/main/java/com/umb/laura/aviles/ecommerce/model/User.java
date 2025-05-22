package com.umb.laura.aviles.ecommerce.model;

import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private String address;
    private Integer cityId;
}
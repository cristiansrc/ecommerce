package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BuyPay {
    private Timestamp datePay;
    private String address;
    private Integer id;
}

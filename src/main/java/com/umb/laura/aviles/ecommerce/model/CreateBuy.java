package com.umb.laura.aviles.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CreateBuy {
    private Integer id;
    private Integer userId;
    private Timestamp date;
    private Timestamp datePay;
    private Integer buyStateId;
}

package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.Buy;
import com.umb.laura.aviles.ecommerce.repository.BuyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
public class BuyService {

    private BuyRepository buyRepository;

    public List<Buy> getBuys() {
        return buyRepository.getBuys();
    }

    public Buy getBuy(Integer id) {
        return buyRepository.getBuy(id);
    }

    public List<Buy> getBuysByUserId(Integer userId, Integer buyStateId){
        return buyRepository.getBuysByUserId(userId, buyStateId);
    }

    public Integer insertBuy(Buy buy) {
        return buyRepository.insertBuy(buy);
    }

    public void editBuyPay(Timestamp datePay, String address, Integer id){
        buyRepository.editDateBuyPay(datePay, address, id);
    }
}

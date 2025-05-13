package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.BuyState;
import com.umb.laura.aviles.ecommerce.repository.BuyStateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuyStateService {

    private BuyStateRepository buyStateRepository;

    public List<BuyState> findAll() {
        return buyStateRepository.findAll();
    }
}

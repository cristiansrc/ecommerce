package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.BuyProduct;
import com.umb.laura.aviles.ecommerce.model.BuyProductAllCharacteristics;
import com.umb.laura.aviles.ecommerce.model.BuyProductCharacteristics;
import com.umb.laura.aviles.ecommerce.repository.BuyProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuyProductService {

    private BuyProductRepository buyProductRepository;

    public Integer addBuyProduct(BuyProduct buyProduct) {
        return buyProductRepository.addBuyProduct(buyProduct);
    }

    public Integer addBuyProductCharacteristics(BuyProductCharacteristics buyProductCharacteristics) {
        return buyProductRepository.addBuyProductCharacteristics(buyProductCharacteristics);
    }

    public List<BuyProductAllCharacteristics> getAllBuyProducts(Integer buyId) {
        return buyProductRepository.getAllBuyProductsXBuyId(buyId);
    }

    public void deleteBuyProduct(Integer id) {
        buyProductRepository.deleteBuyProduct(id);
    }

    public void deleteBuyProductXBuy(Integer buyId) {
        buyProductRepository.deleteBuyProductXBuy(buyId);
    }

}

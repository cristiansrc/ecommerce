package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.ProductCharacteristics;
import com.umb.laura.aviles.ecommerce.repository.ProductCharacteristicsImageRepository;
import com.umb.laura.aviles.ecommerce.repository.ProductCharacteristicsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCharacteristicsService {

    private ProductCharacteristicsRepository productCharacteristicsRepository;
    private ProductCharacteristicsImageRepository productCharacteristicsImageRepository;

    public Integer addProductCharacteristics(ProductCharacteristics productCharacteristics) {
        return productCharacteristicsRepository.addProductCharacteristics(productCharacteristics);
    }

    public void updateProductCharacteristics(ProductCharacteristics productCharacteristics) {
        productCharacteristicsRepository.updateProductCharacteristics(productCharacteristics);
    }

    public void deleteProductCharacteristics(Integer id) {
        productCharacteristicsRepository.deleteProductCharacteristics(id);
        productCharacteristicsImageRepository.deleteProductCharacteristicsImageXCharacteristics(id);
    }

    public void deleteProductCharacteristicsXProduct(Integer productId) {
        productCharacteristicsRepository.deleteProductCharacteristicsXProduct(productId);
        productCharacteristicsImageRepository.deleteProductCharacteristicsImageXProductId(productId);
    }

    public ProductCharacteristics getProductCharacteristics(Integer id) {
        ProductCharacteristics productCharacteristics = productCharacteristicsRepository.getProductCharacteristics(id);

        productCharacteristics.setProductCharacteristicsImages(
            productCharacteristicsImageRepository.getProductCharacteristicsImageByProductIdSimple(id));

        return productCharacteristics;
    }

    public List<ProductCharacteristics> getProductCharacteristicsXProduct(Integer productId) {
        return productCharacteristicsRepository.getProductCharacteristicsXProduct(productId);
    }
}

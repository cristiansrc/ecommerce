package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.ProductCharacteristicsImage;
import com.umb.laura.aviles.ecommerce.repository.ProductCharacteristicsImageRepository;
import com.umb.laura.aviles.ecommerce.utils.ImageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ProductCharacteristicsImageService {

    private ProductCharacteristicsImageRepository productCharacteristicsImageRepository;
    private ImageUtils imageUtils;

    public Integer addProductCharacteristicsImage(ProductCharacteristicsImage productCharacteristicsImage)
            throws IOException {
        String nameImage = imageUtils.saveBase64Image(
                productCharacteristicsImage.getImage(), productCharacteristicsImage.getName());

        productCharacteristicsImage.setImage(nameImage);
        return productCharacteristicsImageRepository.addProductCharacteristicsImage(productCharacteristicsImage);
    }

    public void deleteProductCharacteristicsImage(Integer id) {
        productCharacteristicsImageRepository.deleteProductCharacteristicsImage(id);
    }
}

package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.ProductImage;
import com.umb.laura.aviles.ecommerce.repository.ProductImageRepository;
import com.umb.laura.aviles.ecommerce.utils.ImageUtils;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductImageService {
    
    private ProductImageRepository productImageRepository;
    private ImageUtils imageUtils;

    public Integer addProductImage(ProductImage productImage) throws IOException {
        String nameImage = imageUtils.saveBase64Image(productImage.getImage(), productImage.getName());
        productImage.setImage(nameImage);
        return productImageRepository.addProductImage(productImage);
    }

    public void deleteProductImage(Integer id) {
        productImageRepository.deleteProductImage(id);
    }

    public ProductImage getProductImage(Integer id) {
        return productImageRepository.getProductImage(id);
    }

    public List<ProductImage> getProductImageXProductId(Integer productId) {
        return productImageRepository.getProductImageXProductId(productId);
    }
}

package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.*;
import com.umb.laura.aviles.ecommerce.repository.ProductCharacteristicsImageRepository;
import com.umb.laura.aviles.ecommerce.repository.ProductImageRepository;
import com.umb.laura.aviles.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private ProductCharacteristicsImageRepository productCharacteristicsImageRepository;
    private ProductImageRepository productImageRepository;

    private static final String QUERY = "select  " +
            " product.id, " +
            " product.name,  " +
            " product_image.image, " +
            " (select  " +
            "  min(price)  " +
            " from product_characteristics pc  " +
            " where pc.\"productId\" = product.id) as minPrice, " +
            " (select  " +
            "  max(price)  " +
            " from product_characteristics pc  " +
            " where pc.\"productId\" = product.id) as maxPrice " +
            "  " +
            "from product  " +
            " inner join product_characteristics " +
            "  on product.id = product_characteristics.\"productId\" and product_image.major=0 " +
            " inner join product_image  " +
            "  on product.id = product_image.\"productId\" " +
            " " +
            "where 1=1 ";

    private static final String QUERY_PRODUCT = "" +
            "SELECT " +
            "product.id, " +
            "product.name, " +
            "product.description, " +
            "product.gender, " +
            "(CASE product.gender " +
            "   WHEN 'm' THEN 'Mujer' " +
            "       WHEN 'h' THEN 'Hombre' " +
            "   END) as \"genderName\", " +
            "product.price, " +
            "product.\"categoryId\", " +
            "category.name as \"categoryName\" " +
            " " +
            "FROM product " +
            "INNER JOIN category " +
            "   ON product.\"categoryId\" = category.id " +
            " " +
            "WHERE 1 = 1 ";

    private static final String QUERY_FILTER_GENDER = " and product.gender = ? ";
    private static final String QUERY_FILTER_CATEGORY = " and product.\"categoryId\" in (%s) ";
    private static final String QUERY_FILTER_PRICE = " and (product_characteristics.price between ? and ?) ";
    private static final String QUERY_FILTER_COLOR = " and product_characteristics.\"colorId\" in (%s) ";
    private static final String QUERY_FILTER_SIZE = " and product_characteristics.\"sizeId\" in (%S) ";

    private static final String QUERY_PRODUCT_FILTER_CATEGORY = " AND product.\"categoryId\" = ? ";
    private static final String QUERY_PRODUCT_FILTER_PRICE_MIN = " AND product.price >= ? ";
    private static final String QUERY_PRODUCT_FILTER_PRICE_MAX = " AND product.price <= ? ";
    private static final String QUERY_PRODUCT_FILTER_GENDER = " AND product.gender = ?  ";


    public Integer addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(Integer productId) {
        productImageRepository.deleteProductImageXProduct(productId);
        productRepository.deleteProduct(productId);
    }
    
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
    
    public Product getProductSimple(Integer id){
        return productRepository.getProductSimple(id);
    }

    public ProductInfo getProduct(Integer productId) {

        List<ProductColor> productColorsOld = productRepository.getProductColorsProduct(productId);
        List<ProductColor> productColors = new ArrayList<>();

        for(ProductColor productColor : productColorsOld) {
            productColor.setProductCharacteristicsImages(
                    productCharacteristicsImageRepository.getProductCharacteristicsImageByProductId(productId, productColor.getId()));

            productColors.add(productColor);
        }

        ProductInfo productInfo = productRepository.getProduct(productId);
        productInfo.setProductColors(productColors);
        productInfo.setProductSizes(productRepository.getProductSizesXProduct(productId));
        productInfo.setProductImages(productRepository.getProductImagesXProduct(productId));

        return productInfo;
    }

    public List<ProductFill> getProductsDinamicFilter(FiltersProductIn filtersProductIn) {
        StringBuilder query = new StringBuilder();
        List<Object> paramsList = new ArrayList<>();

        query.append(QUERY);

        query.append(QUERY_FILTER_GENDER);
        paramsList.add(filtersProductIn.getGender());

        if(filtersProductIn.getMinPrice() != null && filtersProductIn.getMaxPrice() != null){
            query.append(QUERY_FILTER_PRICE);
            paramsList.add(filtersProductIn.getMinPrice());
            paramsList.add(filtersProductIn.getMaxPrice());
        }

        this.queryFilterConstruct(query, filtersProductIn.getCategoryIds(), QUERY_FILTER_CATEGORY, paramsList);
        this.queryFilterConstruct(query, filtersProductIn.getColorIds(), QUERY_FILTER_COLOR, paramsList);
        this.queryFilterConstruct(query, filtersProductIn.getSizeIds(), QUERY_FILTER_SIZE, paramsList);

        return productRepository.getProductsDinamicQuery(query.toString(), paramsList.toArray());
    }

    private void queryFilterConstruct(StringBuilder query, List<Integer> ids, String queryFilter, List<Object> paramsList) {
        if(!ids.isEmpty()){
            query.append(String.format(
                queryFilter,
                String.join(",", Collections.nCopies(ids.size(), "?"))
            ));

            paramsList.addAll(ids);
        }
    }


    public List<ProductShopping> queryFilterShoppingConstruct(String gender, Integer categoryId, Integer minPrice, Integer maxPrice) {
        StringBuilder query = new StringBuilder();
        query.append(QUERY_PRODUCT);
        query.append(QUERY_PRODUCT_FILTER_GENDER);

        List<Object> paramsList = new ArrayList<>();
        paramsList.add(gender);

        if(categoryId != null){
            query.append(QUERY_PRODUCT_FILTER_CATEGORY);
            paramsList.add(categoryId);
        }

        if(minPrice != null){
            query.append(QUERY_PRODUCT_FILTER_PRICE_MIN);
            paramsList.add(minPrice);
        }

        if(maxPrice != null){
            query.append(QUERY_PRODUCT_FILTER_PRICE_MAX);
            paramsList.add(maxPrice);
        }

        List<ProductShopping> productShoppings = productRepository.getProductsShopping(query.toString(), paramsList.toArray());
        List<ProductShopping> productShoppingsImages = new ArrayList<>();

        for(ProductShopping productShopping : productShoppings){
            productShopping.setProductImages(productImageRepository.getProductImageXProductId(productShopping.getId()));
            productShoppingsImages.add(productShopping);
        }

        return productShoppingsImages;
    }

    public ProductShopping queryFilterShoppingConstructXIdProduct(Integer id){
        ProductShopping productShopping = productRepository.getProductShoppingXProduct(id);
        productShopping.setProductImages(productImageRepository.getProductImageXProductId(productShopping.getId()));
        return productShopping;
    }
}

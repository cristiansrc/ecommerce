package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.ProductCharacteristicsImage;
import lombok.AllArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductCharacteristicsImageRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer addProductCharacteristicsImage(ProductCharacteristicsImage productCharacteristicsImage) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO product_characteristics_image ( " +
                            "        name, image, \"producCharacteristicsId\") " +
                            "        VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, productCharacteristicsImage.getName());
            ps.setString(2, productCharacteristicsImage.getImage());
            ps.setInt(3, productCharacteristicsImage.getProductCharacteristicsId());
            return ps;
        });

        return keyHolder.getKey().intValue();
    }

    public void deleteProductCharacteristicsImage(Integer id) {
        jdbcTemplate.update(
            "DELETE FROM product_characteristics_image " +
                    "        WHERE id=?;",
            id
        );
    }

    public void deleteProductCharacteristicsImageXCharacteristics(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM product_characteristics_image " +
                        "        WHERE \"productCharacteristicsId\"=?;",
                id
        );
    }

    public void deleteProductCharacteristicsImageXProductId(Integer id) {
        jdbcTemplate.update(
                "delete from product_characteristics_image  " +
                        "where \"productCharacteristicsId\" in ( " +
                        " select id FROM product_characteristics WHERE \"productId\"=1 " +
                        ");",
                id
        );
    }

    public List<ProductCharacteristicsImage> getProductCharacteristicsImageAllImagenes(Integer id) {
        return jdbcTemplate.query(
            "DELETE FROM product_characteristics_image " +
                    " WHERE \"productCharacteristicsId\"=?",
            new BeanPropertyRowMapper<>(ProductCharacteristicsImage.class),
            id
        );
    }

    public List<ProductCharacteristicsImage> getProductCharacteristicsImageByProductId(Integer productId, Integer colorId) {
        return jdbcTemplate.query(
                "select  " +
                        " " +
                        " product_characteristics_image.id, " +
                        " product_characteristics_image.name, " +
                        " product_characteristics_image.image, " +
                        " product_characteristics_image.\"productCharacteristicsId\" " +
                        " " +
                        "from product_color  " +
                        " inner join product_characteristics " +
                        "  on product_characteristics.\"colorId\" = product_color.id " +
                        " inner join  product " +
                        "  on product_characteristics.\"productId\" = product.id " +
                        " inner join product_characteristics_image " +
                        "  on product_characteristics_image.\"productCharacteristicsId\" = product_characteristics_image.id " +
                        " " +
                        "where product.id=? and product_color.id=?",
                new BeanPropertyRowMapper<>(ProductCharacteristicsImage.class),
                productId, colorId
        );
    }

    public List<ProductCharacteristicsImage> getProductCharacteristicsImageByProductIdSimple(Integer productCharacteristicsId) {
        return jdbcTemplate.query(
                "SELECT id, name, image, \"productCharacteristicsId\" " +
                        " FROM product_characteristics_image " +
                        "WHERE \"productCharacteristicsId\"=?",
                new BeanPropertyRowMapper<>(ProductCharacteristicsImage.class),
                productCharacteristicsId
        );
    }
}

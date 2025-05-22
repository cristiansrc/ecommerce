package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.ProductImage;
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
public class ProductImageRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer addProductImage(ProductImage productImage) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO product_image(name, image, \"productId\") " +
                            "        VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productImage.getName());
            ps.setString(2, productImage.getImage());
            ps.setInt(3, productImage.getProductId());
            return ps;
        }, keyHolder);

        return Integer.valueOf(keyHolder.getKeys().get("id").toString());
    }

    public void deleteProductImage(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM product_image WHERE id=?;",
                id
        );
    }
    
    public void deleteProductImageXProduct(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM product_image WHERE \"productId\"=?;",
                id
        );
    }

    public ProductImage getProductImage(Integer id) {
        return DataAccessUtils.singleResult(
            jdbcTemplate.query(
            "SELECT id, name, image, \"productId\" " +
                    "        FROM product_image where id=?;",
                new BeanPropertyRowMapper<>(ProductImage.class),
                id
            )
        );
    }

    public List<ProductImage> getProductImageXProductId(Integer id) {
        return jdbcTemplate.query(
            "SELECT id, name, image, \"productId\" " +
                    "        FROM product_image where \"productId\"=?;",
            new BeanPropertyRowMapper<>(ProductImage.class),
            id
        );

    }

}

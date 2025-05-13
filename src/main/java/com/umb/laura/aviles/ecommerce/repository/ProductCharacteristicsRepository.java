package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.ProductCharacteristics;
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
public class ProductCharacteristicsRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer addProductCharacteristics(ProductCharacteristics productCharacteristics) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO product_characteristics( " +
                            " price, stock, \"colorId\", \"sizeId\", \"productId\") " +
                            " VALUES (?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS

            );

            ps.setDouble(1, productCharacteristics.getPrice());
            ps.setInt(2, productCharacteristics.getStock());
            ps.setInt(3, productCharacteristics.getColorId());
            ps.setInt(4, productCharacteristics.getSizeId());
            ps.setInt(5, productCharacteristics.getProductId());
            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public void updateProductCharacteristics(ProductCharacteristics productCharacteristics) {
        jdbcTemplate.update(
                "UPDATE product_characteristics " +
                        "        SET price=?, stock=?, \"colorId\"=?, \"sizeId\"=?, \"productId\"=?  " +
                        "        WHERE id=?;",
                productCharacteristics.getPrice(),
                productCharacteristics.getStock(),
                productCharacteristics.getColorId(),
                productCharacteristics.getSizeId(),
                productCharacteristics.getProductId(),
                productCharacteristics.getId()
        );
    }

    public ProductCharacteristics getProductCharacteristics(Integer id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        "SELECT id, price, stock, \"colorId\", \"sizeId\", \"productId\" " +
                                "        FROM product_characteristics where id=?;",
                        new BeanPropertyRowMapper<>(ProductCharacteristics.class),
                        id
                )
        );
    }

    public List<ProductCharacteristics> getProductCharacteristicsXProduct(Integer id) {
        return jdbcTemplate.query(
                "SELECT id, price, stock, \"colorId\", \"sizeId\", \"productId\" " +
                        "        FROM product_characteristics where \"productId\"=?;",
                new BeanPropertyRowMapper<>(ProductCharacteristics.class),
                id
        );
    }

    public void deleteProductCharacteristics(Integer id) {
        jdbcTemplate.update(
            "DELETE FROM product_characteristics WHERE id=?;",
            id
        );
    }

    public void deleteProductCharacteristicsXProduct(Integer productId) {
        jdbcTemplate.update(
                "DELETE FROM product_characteristics WHERE \"productId\"=?;",
                productId
        );
    }
}

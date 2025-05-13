package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.BuyProduct;
import com.umb.laura.aviles.ecommerce.model.BuyProductAllCharacteristics;
import com.umb.laura.aviles.ecommerce.model.BuyProductCharacteristics;
import lombok.AllArgsConstructor;
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
public class BuyProductRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer addBuyProduct(BuyProduct buyProduct) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO buy_product( " +
                            "                name, \"buyId\") " +
                            "        VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, buyProduct.getName());
            ps.setInt(2, buyProduct.getId());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public Integer addBuyProductCharacteristics(BuyProductCharacteristics buyProductCharacteristics){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO buy_product_characteristics( " +
                            "                price, items, color, size, \"colorHexa\", \"buyProductId\", image) " +
                            "        VALUES (?, ?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setDouble(1, buyProductCharacteristics.getPrice());
            ps.setInt(2, buyProductCharacteristics.getItems());
            ps.setString(3, buyProductCharacteristics.getColor());
            ps.setString(4, buyProductCharacteristics.getSize());
            ps.setString(5, buyProductCharacteristics.getColorHexa());
            ps.setInt(6, buyProductCharacteristics.getBuyProductId());
            ps.setString(7, buyProductCharacteristics.getImage());
            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public List<BuyProductAllCharacteristics> getAllBuyProductsXBuyId(Integer buyId) {
        return jdbcTemplate.query(
                "SELECT  " +
                        " buy_product.id, " +
                        " buy_product_characteristics.id as \"buyProductCharacteristicsId\", " +
                        " buy_product.name, " +
                        " buy_product_characteristics.price, " +
                        " buy_product_characteristics.items, " +
                        " buy_product_characteristics.color, " +
                        " buy_product_characteristics.size, " +
                        " buy_product_characteristics.image, " +
                        " buy_product_characteristics.\"colorHexa\" " +
                        "  " +
                        "FROM buy_product  " +
                        " inner join buy_product_characteristics " +
                        "  on buy_product.id = buy_product_characteristics.\"buyProductId\" " +
                        " " +
                        "where buy_product.\"buyId\"=?",
                new BeanPropertyRowMapper<>(BuyProductAllCharacteristics.class),
                buyId
        );
    }

    public void deleteBuyProduct(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM buy_product WHERE id=?;",
                id
        );
    }

    public void deleteBuyProductXBuy(Integer buyId) {
        jdbcTemplate.update(
                "DELETE FROM buy_product WHERE id=?;",
                buyId
        );
    }
}

package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.Buy;
import lombok.AllArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Repository
@AllArgsConstructor
public class BuyRepository {

    private JdbcTemplate jdbcTemplate;

    public List<Buy> getBuys() {
        return jdbcTemplate.query(
                "SELECT id, \"userId\", date, \"buyStateId\", \"datePay\" FROM buy;",
                new BeanPropertyRowMapper<>(Buy.class)
        );
    }

    public Buy getBuy(Integer id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        "SELECT id, \"userId\", date, \"buyStateId\", \"datePay\" FROM buy WHERE id=?",
                        new BeanPropertyRowMapper<>(Buy.class),
                        id
                )
        );
    }

    public List<Buy> getBuysByUserId(Integer userId, Integer buyStateId) {
        return jdbcTemplate.query(
                "SELECT id, \"userId\", date, \"buyStateId\", \"datePay\" FROM buy WHERE \"userId\"=? and \"buyStateId\"=?",
                new BeanPropertyRowMapper<>(Buy.class),
                userId,
                buyStateId
        );
    }

    public Integer insertBuy(Buy buy) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO buy( " +
                            "                    \"userId\", date, \"buyStateId\", \"datePay\") " +
                            "            VALUES (?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, buy.getUserId());
            ps.setTimestamp(2, buy.getDate());
            ps.setInt(3, buy.getBuyStateId());
            ps.setTimestamp(4, buy.getBuyDate());

            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public void editDateBuyPay(Timestamp datePay, String address, Integer id){
        jdbcTemplate.update(
                "UPDATE buy SET \"datePay\"=? address=? WHERE id=?;",
                datePay, address, id
        );
    }
}

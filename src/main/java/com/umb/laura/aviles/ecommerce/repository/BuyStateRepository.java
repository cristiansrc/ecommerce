package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.BuyState;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BuyStateRepository {

    private JdbcTemplate jdbcTemplate;

    public List<BuyState> findAll() {
        return jdbcTemplate.query(
                "SELECT id, name FROM buy_state;",
                new BeanPropertyRowMapper<>(BuyState.class)
        );
    }
}

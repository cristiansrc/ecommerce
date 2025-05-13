package com.umb.laura.aviles.ecommerce.repository;


import com.umb.laura.aviles.ecommerce.model.City;
import lombok.AllArgsConstructor;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CityRepository {

    private JdbcTemplate jdbcTemplate;

    public List<City> findAllXDeparment(Integer deparmentId) {
        return jdbcTemplate.query(
                "SELECT id, name, \"departmentId\" FROM city where \"departmentId\"=? order by name desc;",
                new BeanPropertyRowMapper<>(City.class)
        );
    }

}

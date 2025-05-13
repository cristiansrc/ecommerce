package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.Department;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DeparmentRepostory {

    private JdbcTemplate jdbcTemplate;

    public List<Department> getDepartments() {
        return jdbcTemplate.query(
                "SELECT id, name FROM department order by name desc;",
                new BeanPropertyRowMapper<>(Department.class)
        );
    }
}

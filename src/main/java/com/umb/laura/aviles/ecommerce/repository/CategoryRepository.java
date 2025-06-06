package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.Category;
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
public class CategoryRepository {

    private JdbcTemplate jdbcTemplate;

    public Long addCategory(Category category) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO category(name, description) " +
                            "        VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            return ps;
        }, keyHolder);

        return Integer.valueOf(keyHolder.getKeys().get("id").toString());
    }

    public void updateCategory(Category category) {
        jdbcTemplate.update(
                "UPDATE category " +
                        "        SET name=?, description=? " +
                        "        WHERE id=?;",
                category.getName(),
                category.getDescription(),
                category.getId()
        );
    }

    public Category getCategory(Integer id) {
        return DataAccessUtils.singleResult(
            jdbcTemplate.query(
                "SELECT id, name, description FROM category WHERE id=?;",
                new BeanPropertyRowMapper<>(Category.class),
                id
            )
        );
    }

    public List<Category> getAllCategories() {
        return jdbcTemplate.query(
                "SELECT id, name, description FROM category;",
                new BeanPropertyRowMapper<>(Category.class)
        );
    }

    public void deleteCategory(Integer id) {
        jdbcTemplate.update(
            "DELETE FROM category WHERE id=?;", id
        );
    }
}

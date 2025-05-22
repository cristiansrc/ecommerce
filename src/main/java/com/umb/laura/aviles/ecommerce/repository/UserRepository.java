package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.LoginUser;
import com.umb.laura.aviles.ecommerce.model.User;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public void registerUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO \"user\"( " +
                        "                name, \"lastName\", mail, password, phone, address, \"cityId\") " +
                        "        VALUES (?, ?, ?, ?, ?, ?, ?);",
                user.getName(),
                user.getLastName(),
                user.getMail(),
                user.getPassword(),
                user.getPhone(),
                user.getAddress(),
                user.getCityId()
        );
    }

    public User loginUser(LoginUser loginUser) {
        return DataAccessUtils.singleResult(
            jdbcTemplate.query(
                "SELECT id, name, \"lastName\", mail, password, phone, address, \"cityId\" " +
                    "        FROM \"user\" where mail=? and password=?;",
                    new BeanPropertyRowMapper<>(User.class), loginUser.getEmail(), loginUser.getPassword()
            )
        );
    }

    public Optional<User> getUserXMail(String mail) {
        return Optional.of(
            DataAccessUtils.singleResult(
                jdbcTemplate.query(
                    "SELECT id, name, \"lastName\", mail, password, phone, address, \"cityId\" " +
                        "        FROM \"user\" where mail=?;",
                        new BeanPropertyRowMapper<>(User.class), mail
                )
            )
        );
    }
}

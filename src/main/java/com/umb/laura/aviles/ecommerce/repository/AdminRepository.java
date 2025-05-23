package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.Admin;
import com.umb.laura.aviles.ecommerce.model.AuthAdmin;

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
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AdminRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer addAdmin(Admin admin) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO admin(name, \"lastName\", mail, password) VALUES (?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getLastName());
            ps.setString(3, admin.getMail());
            ps.setString(4, admin.getPassword());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public AuthAdmin loginAdmin(String mail, String password) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        "SELECT id, name, \"lastName\", mail, password, phone, address  " +

                                " FROM \"user\" where mail = ? and password = ?",
                        new BeanPropertyRowMapper<>(Admin.class),
                        mail,
                        password
                )
        );
    }

    public Optional<Admin> getAdminXMail(String mail) {
        return Optional.of(
            DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        "select id, name, \"lastName\", mail " +
                            " from admin where mail = ? ",
                        new BeanPropertyRowMapper<>(Admin.class),
                        mail
                )
            )
        );
    }

    public Admin getAdmin(Integer id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                    "SELECT id, name, \"lastName\", mail, password, phone, address " +
                            "FROM\"user\" where id = ?",
                        new BeanPropertyRowMapper<>(Admin.class),
                        id
                )
        );
    }

    public List<Admin> getAllAdmins() {
        return jdbcTemplate.query(
                "SELECT id, name, \"lastName\", mail, password, phone, address  " +
                        "FROM\"user\"",
                new BeanPropertyRowMapper<>(Admin.class)
        );
    }

    public void updateAdmins(Admin admin) {
        jdbcTemplate.update(
                "UPDATE admin " +
                        "        SET name=?, \"lastName\"=?, mail=?, password=?  " +
                        "        WHERE id=?;",
                admin.getName(),
                admin.getLastName(),
                admin.getMail(),
                admin.getPassword(),
                admin.getId()
        );
    }

    public void deleteAdmin(Integer id) {
        jdbcTemplate.update(
            "DELETE FROM admin WHERE id=?;", id
        );
    }
}

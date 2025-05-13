package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.Admin;
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

    public Admin loginAdmin(String mail, String password) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        "SELECT id, name, \"lastName\", mail, password, phone, address, \"cityId\"  " +
                                "FROM\"user\" where mail = ? and password = ?",
                        new BeanPropertyRowMapper<>(Admin.class),
                        mail,
                        password
                )
        );
    }

    public Admin getAdmin(Integer id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                    "SELECT id, name, \"lastName\", mail, password, phone, address, \"cityId\"  " +
                            "FROM\"user\" where id = ?",
                        new BeanPropertyRowMapper<>(Admin.class),
                        id
                )
        );
    }

    public List<Admin> getAllAdmins() {
        return jdbcTemplate.query(
                "SELECT id, name, \"lastName\", mail, password, phone, address, \"cityId\"  " +
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
            "DELETE FROM category  WHERE id=?;", id
        );
    }
}

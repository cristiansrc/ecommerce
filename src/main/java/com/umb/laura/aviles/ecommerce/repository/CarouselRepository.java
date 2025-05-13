package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.Carousel;
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
public class CarouselRepository {

    private JdbcTemplate jdbcTemplate;

    public Integer addCarousel(Carousel carousel) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO carousel(green, black, image) " +
                        "        VALUES (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, carousel.getGreen());
            ps.setString(2, carousel.getBlack());
            ps.setString(3, carousel.getImage());

            return ps;
        });

        return keyHolder.getKey().intValue();
    }

    public Carousel getCarouselById(Integer id) {
        return DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        "SELECT green, black, image FROM carousel where id=?;",
                        new BeanPropertyRowMapper<>(Carousel.class),
                        id
                )
        );
    }

    public List<Carousel> getAllCarousels() {
        return jdbcTemplate.query(
                "SELECT green, black, image FROM carousel",
                new BeanPropertyRowMapper<>(Carousel.class)
        );
    }

    public void updateCarousel(Carousel carousel) {
        jdbcTemplate.update(
                "UPDATE carousel " +
                        "        SET green=?, black=?, image=?  " +
                        "        WHERE id=?;",
                carousel.getGreen(),
                carousel.getBlack(),
                carousel.getImage()
        );
    }

    public void deleteCarousel(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM carousel " +
                        " WHERE id=?;",
                id
        );
    }
}

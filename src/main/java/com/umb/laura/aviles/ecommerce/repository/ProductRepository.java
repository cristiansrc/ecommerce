package com.umb.laura.aviles.ecommerce.repository;

import com.umb.laura.aviles.ecommerce.model.*;
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
public class ProductRepository {
   private JdbcTemplate jdbcTemplate;

   public Integer addProduct(Product product) {
       KeyHolder keyHolder = new GeneratedKeyHolder();

       jdbcTemplate.update(connection -> {
           PreparedStatement ps = connection.prepareStatement(
                   "INSERT INTO product(name, description, gender, \"categoryId\") " +
                           "       VALUES (?, ?, ?, ?);",
                   Statement.RETURN_GENERATED_KEYS);

           ps.setString(1, product.getName());
           ps.setString(2, product.getDescription());
           ps.setString(3, product.getGender());
           ps.setInt(4, product.getCategoryId());
           return ps;
       }, keyHolder);

       return keyHolder.getKey().intValue();
   }

   public void updateProduct(Product product) {
       jdbcTemplate.update(
               "UPDATE product " +
                       "       SET name=?, description=?, gender=?, \"categoryId\"=? " +
                       "       WHERE id=?;",
               product.getName(),
               product.getDescription(),
               product.getGender(),
               product.getCategoryId(),
               product.getId()
       );
   }

   public void deleteProduct(Integer id) {
       jdbcTemplate.update(
               "DELETE FROM product WHERE id=?;", id
       );
   }

   public ProductInfo getProduct(Integer id) {
       return DataAccessUtils.singleResult(
               jdbcTemplate.query(
                       "select  " +
                               " product.id,  " +
                               " product.name,  " +
                               " product.description, " +
                               " category.name as \"category\" " +
                               "from product  " +
                               " inner join category " +
                               "  on category.id = product.\"categoryId\" " +
                               "where product.id=1",
                       new BeanPropertyRowMapper<>(ProductInfo.class),
                       id
               )
       );
   }

   public List<ProductFill> getProductsDinamicQuery(String query, Object... params) {
       return jdbcTemplate.query(
               query,
               new BeanPropertyRowMapper<>(ProductFill.class),
               params
       );
   }

   public List<ProductColor> getProductColorsProduct(Integer productId) {
       return jdbcTemplate.query(
               "select  " +
                       " product_color.id, " +
                       " product_color.name, " +
                       " product_color.hex " +
                       "  " +
                       "from product_color  " +
                       " inner join product_characteristics " +
                       "  on product_characteristics.\"colorId\" = product_color.id " +
                       " inner join  product " +
                       "  on product_characteristics.\"productId\" = product.id " +
                       " " +
                       "where product.id=? " +
                       "group by product_color.id",
               new BeanPropertyRowMapper<>(ProductColor.class),
               productId
       );
   }

    public List<ProductSize> getProductSizesXProduct(Integer productId) {
        return jdbcTemplate.query(
                "select  " +
                        " product_size.id, " +
                        " product_size.name " +
                        "  " +
                        "from product_size  " +
                        " inner join product_characteristics " +
                        "  on product_characteristics.\"sizeId\" = product_size.id " +
                        " inner join  product " +
                        "  on product_characteristics.\"productId\" = product.id " +
                        " " +
                        "where product.id=? " +
                        "group by product_size.id",
                new BeanPropertyRowMapper<>(ProductSize.class),
                productId
        );
    }

   public List<ProductImage> getProductImagesXProduct(Integer productId) {
       return jdbcTemplate.query(
               "select id, name, image, productId  " +
                       "from product_image where productId=?",
               new BeanPropertyRowMapper<>(ProductImage.class),
               productId
       );
   }
}

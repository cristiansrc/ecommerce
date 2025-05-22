package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.Category;
import com.umb.laura.aviles.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Long addCategory(Category category) {
        return categoryRepository.addCategory(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category);
    }

    public Category getCategory(Integer id) {
        return categoryRepository.getCategory(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategory(id);
    }
}

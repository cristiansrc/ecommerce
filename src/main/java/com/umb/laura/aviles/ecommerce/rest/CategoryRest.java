package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.Category;
import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/category/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CategoryRest extends Rest {
    private CategoryService categoryService;

    @PostMapping("/api/category/")
    public ResponseEntity<GeneralResponse<Long>> addCategory(@RequestBody Category category) {
        Long response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = categoryService.addCategory(category);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PutMapping("/api/category/")
    public ResponseEntity<GeneralResponse<String>> updateCategory(@RequestBody Category category) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {categoryService.updateCategory(category);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }
    
    public ResponseEntity<GeneralResponse<Category>> getCategoryXid(Integer id) {
        Category response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {response = categoryService.getCategory(id);} catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }
    
    @GetMapping("/api/admin/category/{id}")
    public ResponseEntity<GeneralResponse<Category>> getCategoryXidAdmin(@PathVariable Integer id) {
        return getCategoryXid(id);
    }

    @GetMapping("/api/category/{id}")
    public ResponseEntity<GeneralResponse<Category>> getCategoryXidShopping(@PathVariable Integer id) {
        return getCategoryXid(id);
    }
    
    public ResponseEntity<GeneralResponse<List<Category>>> getCategory() {
        List<Category> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {response = categoryService.getAllCategories();} catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("/api/category/")
    public ResponseEntity<GeneralResponse<List<Category>>> getCategoryShopping() {
        return getCategory();
    }
    
    @GetMapping("/api/admin/category/")
    public ResponseEntity<GeneralResponse<List<Category>>> getCategoryAdmin() {
        return getCategory();
    }

    @DeleteMapping("/api/category/{id}")
    public ResponseEntity<GeneralResponse<String>> updateCategory(@PathVariable Integer id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {categoryService.deleteCategory(id);}
        catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }
}

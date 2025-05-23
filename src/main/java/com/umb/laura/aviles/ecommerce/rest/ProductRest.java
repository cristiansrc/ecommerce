package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.*;
import com.umb.laura.aviles.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ProductRest extends Rest {
    private ProductService productService;


    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addProduct (@RequestBody Product product) {
        Integer response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productService.addProduct(product);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PutMapping("/api/product/")
    public ResponseEntity<GeneralResponse<String>> updateProduct (@RequestBody Product product) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productService.updateProduct(product);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<GeneralResponse<String>> deleteProduct(@PathVariable Integer id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("" ,httpStatus,msg);
    }
    
    @GetMapping("/api/product/simple/{id}")
    public ResponseEntity<GeneralResponse<Product>> getProducts(@PathVariable Integer id) {
        Product response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";
        
        try {
            response = productService.getProductSimple(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }
    
    @GetMapping("/api/product/")
    public ResponseEntity<GeneralResponse<List<Product>>> getProducts() {
        List<Product> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";
        
        try {
            response = productService.getProducts();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    private ResponseEntity<GeneralResponse<ProductInfo>> getProduct(Integer id){
        ProductInfo response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productService.getProduct(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse<List<Product>>> getProductSimple() {
        List<Product> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productService.getAllProducts();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PostMapping("dinamic/filter/")
    public ResponseEntity<GeneralResponse<List<ProductFill>>> addFilter(@RequestBody FiltersProductIn filtersProductIn) {
        List<ProductFill> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productService.getProductsDinamicFilter(filtersProductIn);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("/shopping/{gender}")
    public ResponseEntity<GeneralResponse<List<ProductShopping>>> getProductShopping(
            @PathVariable String gender,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice
    ) {
        List<ProductShopping> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productService.queryFilterShoppingConstruct(gender, categoryId, minPrice, maxPrice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return this.generalResponse(response, httpStatus,msg);
    }

    @GetMapping("/shopping/id/{id}")
    public ResponseEntity<GeneralResponse<ProductShopping>> getProductShoppingXProductId(@PathVariable Integer id) {
        ProductShopping response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productService.queryFilterShoppingConstructXIdProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return this.generalResponse(response, httpStatus,msg);
    }
}

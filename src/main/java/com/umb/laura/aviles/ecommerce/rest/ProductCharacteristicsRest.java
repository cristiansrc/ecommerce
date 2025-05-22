package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.model.ProductCharacteristics;
import com.umb.laura.aviles.ecommerce.service.ProductCharacteristicsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product/characteristics/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ProductCharacteristicsRest extends Rest {
    private ProductCharacteristicsService productCharacteristicsService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addProductCharacteristics(@RequestBody ProductCharacteristics productCharacteristics) {
        Integer response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productCharacteristicsService.addProductCharacteristics(productCharacteristics);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PutMapping("")
    public ResponseEntity<GeneralResponse<String>> updateProductCharacteristics(@RequestBody ProductCharacteristics productCharacteristics) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productCharacteristicsService.updateProductCharacteristics(productCharacteristics);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GeneralResponse<String>> deleteProductCharacteristics(@PathVariable Integer id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productCharacteristicsService.deleteProductCharacteristics(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<GeneralResponse<String>> deleteProductCharacteristicsXProduct(Integer productId) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productCharacteristicsService.deleteProductCharacteristicsXProduct(productId);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralResponse<ProductCharacteristics>> getProductCharacteristics(@PathVariable Integer id) {
        ProductCharacteristics response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productCharacteristicsService.getProductCharacteristics(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<GeneralResponse<List<ProductCharacteristics>>> getProductCharacteristicsXProduct(@PathVariable Integer id) {
        List<ProductCharacteristics> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productCharacteristicsService.getProductCharacteristicsXProduct(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }
}

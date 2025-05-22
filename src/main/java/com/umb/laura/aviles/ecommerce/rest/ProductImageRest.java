package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.model.ProductImage;
import com.umb.laura.aviles.ecommerce.service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/pruduct/image/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ProductImageRest extends Rest {
    private ProductImageService productImageService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addProductImage(@RequestBody ProductImage productImage) {
        Integer response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productImageService.addProductImage(productImage);
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.CONFLICT;
            msg = "No se pudo guardar la imagen";
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GeneralResponse<String>> deleteProductImage(@PathVariable Integer id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productImageService.deleteProductImage(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralResponse<ProductImage>> getProductImage(@PathVariable Integer id) {
        ProductImage response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productImageService.getProductImage(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<GeneralResponse<List<ProductImage>>> getProductImageXProductId(@PathVariable Integer productId){
        List<ProductImage> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productImageService.getProductImageXProductId(productId);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }
}

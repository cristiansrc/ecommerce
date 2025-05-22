package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.model.ProductCharacteristicsImage;
import com.umb.laura.aviles.ecommerce.service.ProductCharacteristicsImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/product/characteristics/image/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ProductCharacteristicsImageRest extends Rest {
    private ProductCharacteristicsImageService productCharacteristicsImageService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addProductCharacteristicsImage(@RequestBody ProductCharacteristicsImage productCharacteristicsImage) {
        Integer response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = productCharacteristicsImageService.addProductCharacteristicsImage(productCharacteristicsImage);
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.CONFLICT;
            msg = "No se pudo subir la imagen";
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @DeleteMapping("")
    public ResponseEntity<GeneralResponse<String>> deleteProductCharacteristicsImage(@RequestParam Integer id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            productCharacteristicsImageService.deleteProductCharacteristicsImage(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

}

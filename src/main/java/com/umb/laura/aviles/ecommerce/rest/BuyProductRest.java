package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.BuyProduct;
import com.umb.laura.aviles.ecommerce.model.BuyProductAllCharacteristics;
import com.umb.laura.aviles.ecommerce.model.BuyProductCharacteristics;
import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.service.BuyProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/buy/product/")
@CrossOrigin(origins = "http://localhost")
@RestController
@AllArgsConstructor
public class BuyProductRest extends Rest {
    private BuyProductService buyProductService;

    @PostMapping("characteristics/")
    public ResponseEntity<GeneralResponse<Integer>> addBuyProductCharacteristics(BuyProductCharacteristics buyProductCharacteristics) {
        Integer id = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "La caracteristica del producto de la compra se guardo correctamente";

        try {
            id = buyProductService.addBuyProductCharacteristics(buyProductCharacteristics);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(id,httpStatus,msg);
    }

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addBuyProduct(@RequestBody  BuyProduct buyProduct) {
        Integer id = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "El producto de la compra se guardo correctamente";

        try {
            id = buyProductService.addBuyProduct(buyProduct);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(id,httpStatus,msg);
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse<List<BuyProductAllCharacteristics>>> getAllBuyProducts(@RequestParam Integer buyId) {
        List<BuyProductAllCharacteristics> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "La caracteristica del producto se guardo correctamente";

        try {
            response = buyProductService.getAllBuyProducts(buyId);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GeneralResponse<String>> deleteBuyProduct(@PathVariable Integer id) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se elimino correctamente";

        try {
            buyProductService.deleteBuyProduct(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @DeleteMapping("buy/{buyId}")
    public ResponseEntity<GeneralResponse<String>> deleteBuyProductXBuy(@PathVariable Integer buyId) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se elimino correctamente";

        try {
            buyProductService.deleteBuyProductXBuy(buyId);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }
}

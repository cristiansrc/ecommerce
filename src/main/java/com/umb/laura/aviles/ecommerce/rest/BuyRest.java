package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.Buy;
import com.umb.laura.aviles.ecommerce.model.BuyPay;
import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.service.BuyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/buy/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class BuyRest extends Rest {

    private BuyService buyService;

    @GetMapping("")
    public ResponseEntity<GeneralResponse<List<Buy>>> getBuys() {

        List<Buy> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = buyService.getBuys();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralResponse<Buy>> getBuy(@PathVariable Integer id) {

        Buy response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = buyService.getBuy(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("user/{userId}/{buyStateId}")
    public ResponseEntity<GeneralResponse<List<Buy>>> getBuysByUserId(@PathVariable Integer userId, @PathVariable Integer buyStateId) {

        List<Buy> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = buyService.getBuysByUserId(userId, buyStateId);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> createBuy(@RequestBody Buy buy) {
        Integer response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = buyService.insertBuy(buy);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PutMapping("")
    public ResponseEntity<GeneralResponse<String>> updateBuy(@RequestBody BuyPay buyPay) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            buyService.editBuyPay(buyPay.getDatePay(), buyPay.getAddress(), buyPay.getId());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }
}

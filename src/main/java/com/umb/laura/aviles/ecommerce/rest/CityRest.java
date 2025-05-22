package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.City;
import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/city/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CityRest extends Rest {
    private CityService cityService;

    @GetMapping("{deparmentId}")
    public ResponseEntity<GeneralResponse<List<City>>> findAllXDeparment(Integer deparmentId) {
        List<City> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try{
            response = cityService.findAllXDeparment(deparmentId);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }
}

package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.Buy;
import com.umb.laura.aviles.ecommerce.model.Carousel;
import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.service.CarouselService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/carousel/")
@CrossOrigin(origins = "http://localhost")
@RestController
@AllArgsConstructor
public class CarouselRest extends Rest {
    private CarouselService carouselService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addCarousel(@RequestBody Carousel carousel){
        Integer response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = carouselService.addCarousel(carousel);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralResponse<Carousel>> getCarouselById(@PathVariable Integer id){
        Carousel response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try{
            response = carouselService.getCarouselById(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @GetMapping("")
    public ResponseEntity<GeneralResponse<List<Carousel>>> getAllCarousels(){
        List<Carousel> response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try{
            response = carouselService.getAllCarousels();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }

    @PutMapping("")
    public ResponseEntity<GeneralResponse<String>> updateCarousel(@RequestBody Carousel carousel){
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try{
            carouselService.updateCarousel(carousel);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GeneralResponse<String>> deleteCarousel(@PathVariable Integer id){
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try{
            carouselService.deleteCarousel(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }
}

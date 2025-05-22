package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.model.LoginUser;
import com.umb.laura.aviles.ecommerce.model.User;
import com.umb.laura.aviles.ecommerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user/")
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class UserRest extends Rest{
    private UserService userService;

    @PostMapping("register/")
    public ResponseEntity<GeneralResponse<String>> registerUser(@RequestBody User user) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            userService.registerUser(user);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @PostMapping("login/")
    public ResponseEntity<GeneralResponse<User>> loginUser(@RequestBody LoginUser loginUser) {
        User response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto corectamente";

        try {
            response = userService.loginUser(loginUser);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "Hubo un error en base de datos";
        }

        return this.generalResponse(response,httpStatus,msg);
    }
}

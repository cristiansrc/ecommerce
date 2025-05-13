package com.umb.laura.aviles.ecommerce.rest;

import com.umb.laura.aviles.ecommerce.model.Admin;
import com.umb.laura.aviles.ecommerce.model.GeneralResponse;
import com.umb.laura.aviles.ecommerce.model.LoginAdmin;
import com.umb.laura.aviles.ecommerce.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/")
@CrossOrigin(origins = "http://localhost")
@RestController
@AllArgsConstructor
public class AdminRest extends Rest {
    private AdminService adminService;

    @PostMapping("")
    public ResponseEntity<GeneralResponse<Integer>> addAdmin(@RequestBody Admin admin) {
        Integer id = null;
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "El admin se guardo correctamente";

        try {
            id = adminService.addAdmin(admin);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "No se pudo guardar el admin";
        }

        return this.generalResponse(id,httpStatus,msg);
    }

    @PostMapping("login")
    public ResponseEntity<GeneralResponse<Admin>> loginAdmin(@RequestBody LoginAdmin loginAdmin) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "El admin se loggeo correctamente";
        Admin respose = null;

        try {
            respose = adminService.loginAdmin(loginAdmin.getEmail(), loginAdmin.getPassword());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "No se pudo guardar el admin";
        }

        return this.generalResponse(respose,httpStatus,msg);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralResponse<Admin>> getAdmin(@PathVariable("id") Integer id){
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Se consulto el admin correctamente";
        Admin respose = null;

        try {
            respose = adminService.getAdmin(id);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "No se pudo consultar el admin";
        }

        return this.generalResponse(respose,httpStatus,msg);
    }

    @GetMapping("allAdmins")
    public ResponseEntity<GeneralResponse<List<Admin>>> getAdmins(){
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "Los admins se consultaron correctamente";
        List<Admin> respose = null;

        try {
            respose = adminService.getAllAdmins();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "No se pudieron consultar los admins";
        }

        return this.generalResponse(respose,httpStatus,msg);
    }

    @PutMapping("")
    public ResponseEntity<GeneralResponse<String>> updateAdmin(@RequestBody Admin admin) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "El admin se actualizo correctamente";

        try {
            adminService.updateAdmin(admin);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "El admin no se actualizo";
        }

        return this.generalResponse("",httpStatus,msg);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GeneralResponse<String>> deleteAdmin(@RequestBody Admin admin) {
        HttpStatus httpStatus = HttpStatus.OK;
        String msg = "El admin se elimina correctamente";

        try {
            adminService.updateAdmin(admin);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            msg = "El admin no se elimino";
        }

        return this.generalResponse("",httpStatus,msg);
    }


}

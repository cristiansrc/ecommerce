package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.Admin;
import com.umb.laura.aviles.ecommerce.model.AuthAdmin;
import com.umb.laura.aviles.ecommerce.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.umb.laura.aviles.ecommerce.utils.Cripto;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private AdminRepository adminRepository;

    public Integer addAdmin(Admin admin) throws Exception {
        admin.setPassword(Cripto.encript(admin.getPassword()));
        return adminRepository.addAdmin(admin);
    }

    public AuthAdmin loginAdmin(String mail, String password) throws Exception {
        AuthAdmin authAdmin = adminRepository.loginAdmin(mail, Cripto.encript(password));
        return authAdmin;
    }

    public Admin getAdmin(Integer id) {
        return adminRepository.getAdmin(id);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public void updateAdmin(Admin admin) throws Exception {
        admin.setPassword(Cripto.encript(admin.getPassword()));
        adminRepository.updateAdmins(admin);
    }

    public void deleteAdmin(Integer id) {
        adminRepository.deleteAdmin(id);
    }

}

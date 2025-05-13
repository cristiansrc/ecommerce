package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.Admin;
import com.umb.laura.aviles.ecommerce.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private AdminRepository adminRepository;

    public Integer addAdmin(Admin admin) {
        return adminRepository.addAdmin(admin);
    }

    public Admin loginAdmin(String mail, String password) {
        return adminRepository.loginAdmin(mail, password);
    }

    public Admin getAdmin(Integer id) {
        return adminRepository.getAdmin(id);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public void updateAdmin(Admin admin) {
        adminRepository.updateAdmins(admin);
    }

    public void deleteAdmin(Integer id) {
        adminRepository.deleteAdmin(id);
    }

}

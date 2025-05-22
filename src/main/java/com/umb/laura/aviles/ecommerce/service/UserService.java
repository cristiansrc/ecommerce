package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.LoginUser;
import com.umb.laura.aviles.ecommerce.model.User;
import com.umb.laura.aviles.ecommerce.repository.UserRepository;
import com.umb.laura.aviles.ecommerce.utils.Cripto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void registerUser(User user) throws Exception {
        user.setPassword(Cripto.encript(user.getPassword()));
        userRepository.registerUser(user);
    }

    public User loginUser(LoginUser loginUser) throws Exception {
        loginUser.setPassword(Cripto.encript(loginUser.getPassword()));
        return userRepository.loginUser(loginUser);
    }
}

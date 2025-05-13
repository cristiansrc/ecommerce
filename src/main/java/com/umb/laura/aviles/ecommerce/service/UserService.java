package com.umb.laura.aviles.ecommerce.service;

import com.umb.laura.aviles.ecommerce.model.LoginUser;
import com.umb.laura.aviles.ecommerce.model.User;
import com.umb.laura.aviles.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.registerUser(user);
    }

    public User loginUser(LoginUser loginUser) {
        return userRepository.loginUser(loginUser);
    }
}

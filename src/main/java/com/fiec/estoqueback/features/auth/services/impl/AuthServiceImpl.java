package com.fiec.estoqueback.features.auth.services.impl;

import com.fiec.estoqueback.features.auth.dto.LoginRequest;
import com.fiec.estoqueback.features.auth.dto.RegisterRequest;
import com.fiec.estoqueback.features.auth.services.AuthService;
import com.fiec.estoqueback.features.user.models.User;
import com.fiec.estoqueback.features.user.models.UserLevel;
import com.fiec.estoqueback.features.user.services.UserService;
import com.fiec.estoqueback.utils.PasswordEncryptor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    //private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
        //this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAccessLevel(UserLevel.ROLE_USER); // Define o nível de acesso padrão
        user.setPicture(request.getPicture());

        return userService.save(user);
    }

    @Override
    public User login(LoginRequest request) {
        return userService.findByEmail(request.getEmail())
                .filter(user -> PasswordEncryptor.matches(request.getPassword(), user.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("Email ou senha inválidos."));
    }
}
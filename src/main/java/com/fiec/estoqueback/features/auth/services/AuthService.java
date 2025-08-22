package com.fiec.estoqueback.features.auth.services;


import com.fiec.estoqueback.features.auth.dto.LoginRequest;
import com.fiec.estoqueback.features.auth.dto.RegisterRequest;
import com.fiec.estoqueback.features.user.models.User;

public interface AuthService {
    User register(RegisterRequest request);
    User login(LoginRequest request);
}
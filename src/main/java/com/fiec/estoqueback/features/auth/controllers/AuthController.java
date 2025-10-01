package com.fiec.estoqueback.features.auth.controllers;

import com.fiec.estoqueback.features.auth.dto.LoginRequest;
import com.fiec.estoqueback.features.auth.dto.LoginResponse;
import com.fiec.estoqueback.features.auth.dto.RegisterRequest;
import com.fiec.estoqueback.features.auth.services.AuthService;
import com.fiec.estoqueback.features.user.models.User;
import com.fiec.estoqueback.utils.JwtService;
import io.jsonwebtoken.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService,
                          JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User newUser = authService.register(request);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User loggedInUser = authService.login(request);
        String jwtToken = this.jwtService.generateTokenComplete(loggedInUser);
        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/loginprova")
    public ResponseEntity<LoginResponse> loginProva(@RequestBody LoginRequest request) {
        request.setEmail("usuario@exemplo.com");
        request.setPassword("Senha123!");
        User loggedInUser = authService.login(request);

        String jwtToken = this.jwtService.generateTokenComplete(loggedInUser);
        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
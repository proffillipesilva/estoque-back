package com.fiec.estoqueback.features.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @GetMapping
    public void test(){
        System.out.println("Teste ok");
    }
}

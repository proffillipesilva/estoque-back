package com.fiec.estoqueback.features.checkouts.controllers;

import com.fiec.estoqueback.features.checkouts.models.dto.CheckoutRequestDto;
import com.fiec.estoqueback.features.checkouts.services.CheckoutService;
import com.fiec.estoqueback.features.user.models.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/checkouts")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping
    UUID createCheckout(@RequestBody @Valid CheckoutRequestDto checkoutRequestDto, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        checkoutRequestDto.setUserId(String.valueOf(user.getId()));
        return checkoutService.checkout(checkoutRequestDto);
    }
}

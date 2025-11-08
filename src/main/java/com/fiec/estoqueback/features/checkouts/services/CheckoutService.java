package com.fiec.estoqueback.features.checkouts.services;

import com.fiec.estoqueback.features.checkouts.models.dto.CheckoutRequestDto;
import com.fiec.estoqueback.features.user.models.User;

import java.util.UUID;

public interface CheckoutService {
    UUID checkout(CheckoutRequestDto checkoutRequestDto);
    void deleteCheckout(String id, User user);
}

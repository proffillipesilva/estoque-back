package com.fiec.estoqueback.features.checkouts.services;

import com.fiec.estoqueback.features.checkouts.models.dto.CheckoutRequestDto;

import java.util.UUID;

public interface CheckoutService {
    UUID checkout(CheckoutRequestDto checkoutRequestDto);
}

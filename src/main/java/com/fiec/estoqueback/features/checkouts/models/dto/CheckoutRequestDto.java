package com.fiec.estoqueback.features.checkouts.models.dto;

import lombok.Data;

@Data
public class CheckoutRequestDto {
    String userId;
    String productId;
    double quantidade;
    double preco;
}

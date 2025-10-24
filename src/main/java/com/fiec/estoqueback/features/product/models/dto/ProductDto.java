package com.fiec.estoqueback.features.product.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    String id;
    String nome;
    String imagem;
    Double preco;
}

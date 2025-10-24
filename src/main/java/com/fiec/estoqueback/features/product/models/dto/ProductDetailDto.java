package com.fiec.estoqueback.features.product.models.dto;

import com.fiec.estoqueback.features.product.models.enums.TipoMedida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {
    String id;
    String nome;
    String imagem;
    TipoMedida tipoMedida;
    Double quantidade;
    Double preco;
    String guestName;
}

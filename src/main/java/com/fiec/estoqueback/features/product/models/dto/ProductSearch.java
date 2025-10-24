package com.fiec.estoqueback.features.product.models.dto;

import com.fiec.estoqueback.features.product.models.enums.TipoMedida;
import lombok.Data;

@Data
public class ProductSearch {
    private String nome;
    private Double preco;
    private TipoMedida tipoMedida;
    private String guestName;
    private SortOrder sortOrder;
    private String sortBy;
}

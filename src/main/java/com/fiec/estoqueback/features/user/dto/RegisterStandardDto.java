package com.fiec.estoqueback.features.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStandardDto extends UserDto {
    String cnpj;

    String nomeDaEmpresa;

    String ramoAtuacao;

}

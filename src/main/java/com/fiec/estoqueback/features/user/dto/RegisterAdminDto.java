package com.fiec.estoqueback.features.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAdminDto extends UserDto {

    @NotNull
    String cnpj;

    @Size(min = 3, max = 40)
    String nomeDaEmpresa;

    String ramoAtuacao;

}

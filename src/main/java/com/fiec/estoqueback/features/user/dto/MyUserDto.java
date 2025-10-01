package com.fiec.estoqueback.features.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // excluir os campos nulos
public class MyUserDto {

    String nome;

    String email;

    String cnpj;

    String cpf;

    String nomeDaEmpresa;

    String tipo;

    String picture;
}

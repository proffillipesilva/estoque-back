package com.fiec.estoqueback.features.user.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterGuestDto extends UserDto {

    @NotNull
    String cpfOrCnpj;

    String city;

    String zipCode;

    @Digits(integer = 10, fraction = 0)
    String number;

}

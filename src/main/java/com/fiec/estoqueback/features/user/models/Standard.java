package com.fiec.estoqueback.features.user.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Standard extends SystemUser {



    String cnpj;

    String nomeDaEmpresa;

    String ramoAtuacao;



    @ManyToMany
    @JoinTable(
            name = "supplier_admin_relationship",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    List<Guest> guests;
}

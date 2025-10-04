package com.fiec.estoqueback.features.user.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Admin extends SystemUser{


    String cnpj;

    String nomeDaEmpresa;

    String ramoAtuacao;



    @ManyToMany
    @JoinTable(
            name = "guest_admin_relationship",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    List<Guest> guests;
}

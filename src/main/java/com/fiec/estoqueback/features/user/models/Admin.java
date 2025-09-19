package com.fiec.estoqueback.features.user.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Admin extends SystemUser{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

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

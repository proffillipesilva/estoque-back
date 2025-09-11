package com.fiec.estoqueback.features.user.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    String cnpj;

    String nomeDaEmpresa;

    String ramoAtuacao;

    @OneToOne
    User user;

    @ManyToMany
    @JoinTable(
            name = "supplier_admin_relationship",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    List<Supplier> suppliers;
}

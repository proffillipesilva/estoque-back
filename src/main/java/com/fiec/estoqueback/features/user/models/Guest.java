package com.fiec.estoqueback.features.user.models;

import com.fiec.estoqueback.features.product.models.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Guest extends SystemUser{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    String cpfOrCnpj;

    String name;

    String city;

    String zipCode;

    String number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guest")
    List<Product> products;

    @OneToOne
    User user;

    @ManyToMany
    List<Admin> admins;

}

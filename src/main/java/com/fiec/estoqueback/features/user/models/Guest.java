package com.fiec.estoqueback.features.user.models;

import com.fiec.estoqueback.features.product.models.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Guest extends SystemUser{

    String cpfOrCnpj;

    String name;

    String city;

    String zipCode;

    String number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guest")
    List<Product> products;

    @ManyToMany
    List<Admin> admins;


}

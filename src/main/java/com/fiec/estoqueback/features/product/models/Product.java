package com.fiec.estoqueback.features.product.models;

import com.fiec.estoqueback.features.user.models.Guest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    Guest guest;


}

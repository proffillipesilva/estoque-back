package com.fiec.estoqueback.features.checkouts.models;

import com.fiec.estoqueback.features.product.models.Product;
import com.fiec.estoqueback.features.user.models.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private Double preco;

    private Long quantidade;

    @CreationTimestamp
    private Date checkoutDate;
}

package com.fiec.estoqueback.features.checkouts.models;

import com.fiec.estoqueback.features.product.models.Product;
import com.fiec.estoqueback.features.user.models.User;
import com.fiec.estoqueback.shared.models.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Where(clause = "is_deleted = false")
public class Checkout extends Auditable<User> {

    @Column(name = "is_deleted")
    private Boolean isDeleted = false; // Default to not deleted

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

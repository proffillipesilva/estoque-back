package com.fiec.estoqueback.features.user.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
//@Table(name = "users")
@Data // Lombok: Gera Getters, Setters, toString, etc.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserLevel accessLevel;

    @Column
    private String picture;
}
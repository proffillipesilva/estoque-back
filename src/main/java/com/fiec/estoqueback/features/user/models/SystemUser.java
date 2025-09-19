package com.fiec.estoqueback.features.user.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class SystemUser {



    @OneToOne
    User user;
}

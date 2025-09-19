package com.fiec.estoqueback.features.user.models;

import jakarta.persistence.*;

import java.util.UUID;

public abstract class SystemUser {



    @OneToOne
    User user;
}

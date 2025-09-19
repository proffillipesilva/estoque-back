package com.fiec.estoqueback.features.user.repositories;

import com.fiec.estoqueback.features.user.models.Admin;
import com.fiec.estoqueback.features.user.models.Guest;
import com.fiec.estoqueback.features.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {
    Optional<Guest> findByUser(User user);
}

package com.fiec.estoqueback.features.user.repositories;

import com.fiec.estoqueback.features.user.models.Guest;
import com.fiec.estoqueback.features.user.models.Standard;
import com.fiec.estoqueback.features.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandardRepository extends JpaRepository<Standard, String> {
    Optional<Standard> findByUser(User user);
}

package com.fiec.estoqueback.features.user.repositories;

import com.fiec.estoqueback.features.user.models.Supplier;
import com.fiec.estoqueback.features.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Supplier, String> {
    Optional<Supplier> findByUser(User user);
}

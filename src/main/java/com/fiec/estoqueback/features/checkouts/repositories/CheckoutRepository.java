package com.fiec.estoqueback.features.checkouts.repositories;

import com.fiec.estoqueback.features.checkouts.models.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {

}

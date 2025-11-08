package com.fiec.estoqueback.features.checkouts.repositories;

import com.fiec.estoqueback.features.checkouts.models.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {

    @Modifying
    @Query("UPDATE Checkout e SET e.isDeleted = true WHERE e.id = :id")
    void softDeleteById(@Param("id") UUID id);

}

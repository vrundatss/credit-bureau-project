package com.creditbureau.repository;

import com.creditbureau.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface CitizenRepository extends JpaRepository<Citizen, UUID> {
    Optional<Citizen> findByPanNumber(String panNumber);
}
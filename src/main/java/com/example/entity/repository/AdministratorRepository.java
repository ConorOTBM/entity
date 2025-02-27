package com.example.entity.repository;

import com.example.entity.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    // Additional query methods can be defined here
}

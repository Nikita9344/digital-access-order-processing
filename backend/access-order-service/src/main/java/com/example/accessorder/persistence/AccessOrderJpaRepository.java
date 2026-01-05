package com.example.accessorder.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessOrderJpaRepository
        extends JpaRepository<AccessOrderEntity, String> {
}
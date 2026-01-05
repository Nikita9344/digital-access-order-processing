package com.example.accessorder.workflow.impl;

import com.example.accessorder.domain.OrderStatus;
import com.example.accessorder.persistence.AccessOrderJpaRepository;
import com.example.accessorder.persistence.mapper.AccessOrderMapper;
import com.example.accessorder.workflow.AccessOrderActivities;
import org.springframework.stereotype.Component;

@Component
public class AccessOrderActivitiesImpl implements AccessOrderActivities {

    private final AccessOrderJpaRepository repository;

    public AccessOrderActivitiesImpl(AccessOrderJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validateOrder(String orderId) {
        // Simulated validation
    }

    @Override
    public void approveOrder(String orderId) {
        repository.findById(orderId).ifPresent(entity -> {
            var domain = AccessOrderMapper.toDomain(entity);
            domain.updateStatus(OrderStatus.APPROVED);
            repository.save(AccessOrderMapper.toEntity(domain));
        });
    }
}
package com.example.accessorder.persistence.mapper;

import com.example.accessorder.domain.AccessOrder;
import com.example.accessorder.domain.OrderStatus;
import com.example.accessorder.persistence.AccessOrderEntity;

public final class AccessOrderMapper {

    private AccessOrderMapper() {}

    public static AccessOrderEntity toEntity(AccessOrder order) {
        return new AccessOrderEntity(
                order.getOrderId(),
                order.getUserId(),
                order.getServiceName(),
                order.getStatus().name(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }

    public static AccessOrder toDomain(AccessOrderEntity entity) {
        return AccessOrder.fromPersistence(
                entity.getOrderId(),
                entity.getUserId(),
                entity.getServiceName(),
                OrderStatus.valueOf(entity.getStatus()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
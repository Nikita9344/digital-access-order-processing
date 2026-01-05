package com.example.accessorder.service;

import com.example.accessorder.domain.AccessOrder;
import com.example.accessorder.domain.OrderStatus;
import com.example.accessorder.persistence.AccessOrderJpaRepository;
import com.example.accessorder.persistence.mapper.AccessOrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.accessorder.workflow.AccessOrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

@Service
public class AccessOrderService {

    private final AccessOrderJpaRepository repository;
    private final WorkflowClient workflowClient;

    public AccessOrderService(
            AccessOrderJpaRepository repository,
            WorkflowClient workflowClient
    ) {
        this.repository = repository;
        this.workflowClient = workflowClient;
    }

    @Transactional
    public AccessOrder createAccessOrder(String userId, String serviceName) {

        AccessOrder order = AccessOrder.createNew(userId, serviceName);
        repository.save(AccessOrderMapper.toEntity(order));

        AccessOrderWorkflow workflow =
                workflowClient.newWorkflowStub(
                        AccessOrderWorkflow.class,
                        WorkflowOptions.newBuilder()
                                .setTaskQueue("ACCESS_ORDER_TASK_QUEUE")
                                .setWorkflowId("access-order-" + order.getOrderId())
                                .build()
                );

        WorkflowClient.start(
                workflow::processAccessOrder,
                order.getOrderId()
        );

        return order;
    }
}
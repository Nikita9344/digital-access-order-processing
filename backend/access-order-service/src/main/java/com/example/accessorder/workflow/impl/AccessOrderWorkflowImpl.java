package com.example.accessorder.workflow.impl;

import com.example.accessorder.workflow.AccessOrderActivities;
import com.example.accessorder.workflow.AccessOrderWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class AccessOrderWorkflowImpl implements AccessOrderWorkflow {

    private final AccessOrderActivities activities =
            Workflow.newActivityStub(
                    AccessOrderActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(10))
                            .build()
            );

    @Override
    public void processAccessOrder(String orderId) {
        activities.validateOrder(orderId);
        activities.approveOrder(orderId);
    }
}
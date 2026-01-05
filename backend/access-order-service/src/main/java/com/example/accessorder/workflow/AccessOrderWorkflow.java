package com.example.accessorder.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface AccessOrderWorkflow {

    @WorkflowMethod
    void processAccessOrder(String orderId);
}
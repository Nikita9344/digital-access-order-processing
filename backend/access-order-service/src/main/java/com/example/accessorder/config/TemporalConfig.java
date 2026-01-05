package com.example.accessorder.config;

import com.example.accessorder.workflow.AccessOrderWorkflow;
import com.example.accessorder.workflow.impl.AccessOrderActivitiesImpl;
import com.example.accessorder.workflow.impl.AccessOrderWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    private static final String TASK_QUEUE = "ACCESS_ORDER_TASK_QUEUE";

    @Bean
    public WorkflowClient workflowClient() {
        WorkflowServiceStubs service =
                WorkflowServiceStubs.newLocalServiceStubs();
        return WorkflowClient.newInstance(service);
    }

    @Bean
    public WorkerFactory workerFactory(
            WorkflowClient workflowClient,
            AccessOrderActivitiesImpl activities
    ) {
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(TASK_QUEUE);

        worker.registerWorkflowImplementationTypes(
                AccessOrderWorkflowImpl.class
        );
        worker.registerActivitiesImplementations(activities);

        factory.start();
        return factory;
    }
}

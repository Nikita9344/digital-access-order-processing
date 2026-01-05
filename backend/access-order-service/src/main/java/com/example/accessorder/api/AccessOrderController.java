package com.example.accessorder.api;

import com.example.accessorder.api.dto.AccessOrderResponse;
import com.example.accessorder.api.dto.CreateAccessOrderRequest;
import com.example.accessorder.domain.AccessOrder;
import com.example.accessorder.service.AccessOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access-orders")
public class AccessOrderController {

    private final AccessOrderService service;

    public AccessOrderController(AccessOrderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccessOrderResponse createAccessOrder(
            @RequestBody CreateAccessOrderRequest request
    ) {
        AccessOrder order =
                service.createAccessOrder(
                        request.getUserId(),
                        request.getServiceName()
                );

        return new AccessOrderResponse(
                order.getOrderId(),
                order.getUserId(),
                order.getServiceName(),
                order.getStatus().name(),
                order.getCreatedAt()
        );
    }
}
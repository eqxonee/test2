package org.example.controller;

import com.example.generated.api.OrderDetailsApi;
import com.example.generated.model.OrderDetailsDto;
import org.example.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailsController implements OrderDetailsApi {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Override
    public ResponseEntity<Void> saveOrderDetails(OrderDetailsDto orderDetailsDto) {
        orderDetailsService.saveOrderDetails(orderDetailsDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long id) {
        orderDetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<OrderDetailsDto>> getAllOrderDetails() {
        List<OrderDetailsDto> orderDetails = orderDetailsService.getAllOrderDetails();
        return ResponseEntity.ok(orderDetails);
    }
}

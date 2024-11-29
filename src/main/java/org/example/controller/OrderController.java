package org.example.controller;

import com.example.generated.api.OrdersApi;
import com.example.generated.model.OrderDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class OrderController implements OrdersApi {

    @Autowired
    private OrderService ordersService;

    @Override
    public ResponseEntity<Void> saveOrder(OrderDto orderDto) {
        ordersService.saveOrder(orderDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        ordersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByDateAndSum(OffsetDateTime date, Double sum) {
        return ResponseEntity.ok(ordersService.getAllByDateAndSum(date, BigDecimal.valueOf(sum)));
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByName(String name) {
        List<OrderDto> ordersByName = ordersService.getAllOrdersByName(name);
        return ResponseEntity.ok(ordersByName);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllWithoutProductAndDate(String productName, OffsetDateTime date) {
        return ResponseEntity.ok(ordersService.getAllWithoutProductAndDate(productName, date));
    }
}

package org.example.api;

import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.example.dto.OrderDto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class OrderApiController implements OrdersApi {

    @Autowired
    private OrderService ordersService;

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @Override
    public ResponseEntity<List<OrderDto>>getAllByName(String name) {
        return ResponseEntity.ok(ordersService.getAllOrdersByName(name));
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByDateAndSum(Timestamp date, BigDecimal sum) {
        return ResponseEntity.ok(ordersService.getAllByDateAndSum(date, sum));
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllWithoutProductAndDate(String productName, OffsetDateTime date) {
        return ResponseEntity.ok(ordersService.getAllWithoutProductAndDate(productName,
                Timestamp.valueOf(date.toLocalDateTime())));
    }

    @Override
    public void addNew(OrderDto orderDto) {
        ordersService.saveOrders(orderDto);
    }

    @Override
    public void deleteById(Long id) {
        ordersService.deleteById(id);
    }

//    @Autowired
//    private OrderService orderService;
//
//    @Override
//    public ResponseEntity<List<OrderDto>> getAllOrders() {
//        List<OrderDto> orders = orderService.getAllOrders();
//        return ResponseEntity.ok(orders);
//    }
//
//    @Override
//    public ResponseEntity<OrderDto> addNewOrder(OrderDto orderDto) {
//        OrderDto createdOrder = orderService.(orderDto);
//        return ResponseEntity.ok(createdOrder);
//    }
//
//    @Override
//    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
//        orderService.deleteOrderById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @Override
//    public ResponseEntity<List<OrderDto>> getOrdersByDateAndSum(
//            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Timestamp date,
//            @PathVariable Double sum) {
//        List<OrderDto> orders = orderService.getOrdersByDateAndSum(date, sum);
//        return ResponseEntity.ok(orders);
//    }
//
//    @Override
//    public ResponseEntity<List<OrderDto>> getOrdersByProductNameAndDate(
//            @PathVariable String productName,
//            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Timestamp date) {
//        List<OrderDto> orders = orderService.getOrdersByProductNameAndDate(productName, date);
//        return ResponseEntity.ok(orders);
//    }
//
//    @Override
//    public ResponseEntity<List<OrderDto>> getOrdersByName(@PathVariable String name) {
//        List<OrderDto> orders = orderService.getOrdersByName(name);
//        return ResponseEntity.ok(orders);
//    }
}

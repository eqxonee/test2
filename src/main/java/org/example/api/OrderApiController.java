package org.example.api;

import com.example.generated.api.OrdersApi;
import com.example.generated.model.OrderDto;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
//import org.example.dto.OrderDto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderApiController implements OrdersApi {

    @Autowired
    private OrderService ordersService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return OrdersApi.super.getRequest();
    }

    @Override
    public ResponseEntity<OrderDto> addNew(OrderDto orderDto) {
        return OrdersApi.super.addNew(orderDto);
    }

    @Override
    public ResponseEntity<Void> deleteById(Integer id) {
        return OrdersApi.super.deleteById(id);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByDateAndSum(OffsetDateTime date, Double sum) {
        return OrdersApi.super.getAllByDateAndSum(date, sum);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByName(String name) {
        return OrdersApi.super.getAllByName(name);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return OrdersApi.super.getAllOrders();
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllWithoutProductAndDate(String productName, OffsetDateTime date) {
        return OrdersApi.super.getAllWithoutProductAndDate(productName, date);
    }


    /*    @Override
    public ResponseEntity<OrderDto> addNew(OrderDto orderDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByDateAndSum(OffsetDateTime date, Double sum) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllWithoutProductAndDate(String productName, OffsetDateTime date) {
        return null;
    }*/



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

package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.OrderDto;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {

    private OrderService ordersService;

    @GetMapping()
    public List<OrderDto>findAll() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{name}")
    public List<OrderDto>getAll(@PathVariable String name) {
        return ordersService.getAllOrdersByName(name);
    }

    @GetMapping("/{date}/{sum}")
    public List<OrderDto>getAllByDateAndSum(@PathVariable Timestamp date, @PathVariable BigDecimal sum) {
        return ordersService.getAllByDateAndSum(date, sum);
    }

    @GetMapping("/filter/{productName}/{date}")
    public List<OrderDto>getAllWithoutProductAndDate(@PathVariable String productName, @PathVariable Timestamp date) {
        return ordersService.getAllWithoutProductAndDate(productName, date);
    }

    @PostMapping()
    public void addNew(@RequestBody OrderDto orderDto) {
        ordersService.saveOrders(orderDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        ordersService.deleteById(id);
    }
}

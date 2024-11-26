package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

//    @Autowired
//    private OrderService ordersService;
//
//    @Override
//    public ResponseEntity<List<OrderDto>> getAllOrders() {
//        return ResponseEntity.ok(ordersService.getAllOrders());
//    }
//
//    @Override
//    public ResponseEntity<List<OrderDto>>getAllByName(String name) {
//        return ResponseEntity.ok(ordersService.getAllOrdersByName(name));
//    }
//
//    @Override
//    public ResponseEntity<List<OrderDto>> getAllByDateAndSum(Timestamp date, BigDecimal sum) {
//        return ResponseEntity.ok(ordersService.getAllByDateAndSum(date, sum));
//    }

//    @GetMapping("/filter/{productName}/{date}")
//    public List<OrderDto>getAllWithoutProductAndDate(@PathVariable String productName, @PathVariable Timestamp date) {
//        return ordersService.getAllWithoutProductAndDate(productName, date);
//    }

//    @PostMapping()
//    public void addNew(@RequestBody OrderDto orderDto) {
//        ordersService.saveOrders(orderDto);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteById(@PathVariable Long id) {
//        ordersService.deleteById(id);
//    }
}

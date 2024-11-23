package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.OrderDetailsDto;
import org.example.service.OrderDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders/details")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;

    @GetMapping()
    public List<OrderDetailsDto> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @PostMapping()
    public void saveOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {
        orderDetailsService.saveOrderDetails(orderDetailsDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        orderDetailsService.deleteById(id);
    }
}

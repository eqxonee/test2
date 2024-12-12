package org.example.service;

import com.example.generated.model.OrderDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrdersByName(String name);

    void saveOrder(OrderDto orderDto);

    void deleteById(Long id);

    List<OrderDto> getAllByDateAndSum(LocalDateTime date, BigDecimal sum);

    List<OrderDto> getAllWithoutProductAndDate(String productName, LocalDateTime date);
}

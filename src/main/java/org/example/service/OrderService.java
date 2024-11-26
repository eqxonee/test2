package org.example.service;

import org.example.dto.OrderDto;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrdersByName(String name);

    void saveOrders(OrderDto orderDto);

    void deleteById(Long id);

    List<OrderDto> getAllByDateAndSum(Timestamp date, BigDecimal sum);

    List<OrderDto> getAllWithoutProductAndDate(String productName, Timestamp date);
}

package org.example.service;

import com.example.generated.model.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {

    void saveOrderDetails(OrderDetailsDto dto);

    List<OrderDetailsDto> getAllOrderDetails();

    void deleteById(Long id);
}

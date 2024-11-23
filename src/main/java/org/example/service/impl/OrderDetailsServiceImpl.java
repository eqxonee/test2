package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.OrderDetailsDto;
import org.example.model.OrderDetails;
import org.example.repository.OrderDetailsRepository;
import org.example.service.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final ModelMapper modelMapper;
    private final OrderDetailsRepository orderDetailsRepository;

    @Transactional
    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {

        List<OrderDetails> orderDetail = orderDetailsRepository.findAll();
        log.debug("Request to get all Orders");

        File file = new File("/Users/airm1/IdeaProjects/test2/src/main/resources/log.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            String log = ("select * from orders_details\n");
            fileOutputStream.write(log.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return orderDetail.stream().map(orders -> modelMapper.map(orders, OrderDetailsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveOrderDetails(OrderDetailsDto dto) {
        if (dto.getId() == null) {
            //Новая запись
            OrderDetails orderDetails = modelMapper.map(dto, OrderDetails.class);
            orderDetailsRepository.save(orderDetails);
        } else {
            //Обновляем существующую
            Optional<OrderDetails> optional = orderDetailsRepository.findById(dto.getId());
            if (optional.isEmpty()) {
                throw new RuntimeException("Заказа с указанным ID не существует -" + dto.getId());
            }

            OrderDetails orderDetails = optional.get();
            modelMapper.map(dto, orderDetails);

            orderDetailsRepository.save(orderDetails);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}

package org.example.service.impl;

import com.example.generated.model.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Number;
import org.example.model.Order;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Transactional
    @Override
    public List<OrderDto> getAllOrders() throws RuntimeException {

        List<Order> order = orderRepository.findAll();
        log.debug("Request to get all Orders");

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<OrderDto> getAllOrdersByName(String name) throws RuntimeException {

        List<Order> order = orderRepository.getAllByRecipient(name);
        log.debug("Request to get all Orders with recipient: {}", name);

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveOrder(OrderDto dto) {
        if (dto.getId() == null) {
            //Новая запись
            try {
                Number number = generateNumber();
                String newCode = number.getNumber();
                if (!isCodeUnique(newCode)) {
                    throw new RuntimeException("Code duplicated");
                }

                Order order = modelMapper.map(dto, Order.class);
                order.setOrderNumber(newCode);
                order.setOrderDate(number.getOrderDate());

                checkTypes(order);
                log.debug("successfully saved order\n");
            } catch (RuntimeException ex) {
                log.error(ex.getMessage());
            }
        } else {
            //Обновляем существующую
            Optional<Order> optional = orderRepository.findById(dto.getId());
            if (optional.isEmpty()) {
                throw new RuntimeException("Заказа с указанным ID не существует -" + dto.getId());
            }

            Order order = optional.get();
            modelMapper.map(dto, order);

            checkTypes(order);
        }
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllByDateAndSum(LocalDateTime date, BigDecimal sum) {
        if (date == null || sum == null) {
            throw new RuntimeException("Поля 'Дата' и 'Сумма заказа' не должны быть пустыми");
        }
        List<Order> order = orderRepository.getAllByDateAndSum(date, sum);
        log.debug("Request to get all Orders by date and sum: {}, {}", date, sum);

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<OrderDto> getAllWithoutProductAndDate(String productName, LocalDateTime date) {
        if (productName.isEmpty() || date == null) {
            throw new RuntimeException("Поля 'Название продукта' и 'Дата' не должны быть пустыми");
        }
        List<Order> order = orderRepository.getAllWithoutProductAndDate(productName, date);
        log.debug("Request to get all Orders without product and date: {}, {}", productName, date);

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    private Number generateNumber() {
        try {
            Number number = restTemplate.getForObject("http://mongoService:8040/numbers", Number.class);
            log.debug("Successfully retrieved new code: {}", number.getNumber());
            log.debug("Successfully retrieved date: {}", number.getOrderDate());
            return number;
        } catch (Exception ex) {
            log.error("Failed to retrieve from mongo service", ex);
            throw ex;
        }
    }

    private void checkTypes(Order order) {
        if (!Objects.equals(order.getPaymentType(), "карта") && !Objects.equals(order.getPaymentType(), "наличные")) {
            throw new RuntimeException("Вы не можете добавить другой тип оплаты, доступно только (карта) и (наличные)");
        }

        if (!Objects.equals(order.getDeliveryType(), "самовывоз") && !Objects.equals(order.getDeliveryType(), "доставка до двери")) {
            throw new RuntimeException("Вы не можете добавить другой тип доставки, доступно только (самовывоз) и (доставка до двери)");
        }

        orderRepository.save(order);
    }

    private boolean isCodeUnique(String code) {
        return !orderRepository.existsByOrderNumber(code);
    }
}

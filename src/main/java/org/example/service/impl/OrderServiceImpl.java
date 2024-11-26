package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Order;
//import org.example.dto.OrderDto;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.example.util.FileOutputStreamUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

/*    @Transactional
    @Override
    public List<OrderDto> getAllOrders() throws RuntimeException {

        List<Order> order = orderRepository.findAll();
        log.debug("Request to get all Orders");

//        FileOutputStreamUtil.fileOutputStream("Select * from order\n\n");

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<OrderDto> getAllOrdersByName(String name) throws RuntimeException {

        List<Order> order = orderRepository.getAllByRecipient(name);
        log.debug("Request to get all Orders with recipient: {}", name);
        String log = String.format("select * from orders where recipient = '%s'\n\n", name);

        FileOutputStreamUtil.fileOutputStream(log);

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveOrders(OrderDto dto) {
        if (dto.getId() == null) {
            //Новая запись
            try {
                Order order = modelMapper.map(dto, Order.class);
                orderRepository.save(order);
                log.debug("successfully saved order\n");
                FileOutputStreamUtil.fileOutputStream("\nsuccessfully saved order\n\n");
            } catch (RuntimeException ex) {
                log.error(ex.getMessage());
                FileOutputStreamUtil.fileOutputStream(log + ex.getMessage());
            }
        } else {
            //Обновляем существующую
            Optional<Order> optional = orderRepository.findById(dto.getId());
            if (optional.isEmpty()) {
                throw new RuntimeException("Заказа с указанным ID не существует -" + dto.getId());
            }

            Order order = optional.get();
            modelMapper.map(dto, order);

            orderRepository.save(order);
        }
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllByDateAndSum(Timestamp date, BigDecimal sum) {
        if (date == null || sum == null) {
            throw new RuntimeException("Поля 'Дата' и 'Сумма заказа' не должны быть пустыми");
        }
        List<Order> order = orderRepository.getAllByDateAndSum(date, sum);
        log.debug("Request to get all Orders by date and sum: {}, {}", date, sum);
        String log = String.format("Select * from orders where order_date = '%s' and order_summ >= '%s'\n\n", date, sum);

        FileOutputStreamUtil.fileOutputStream(log);

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<OrderDto> getAllWithoutProductAndDate(String productName, Timestamp date) {
        if (productName.isEmpty() || date == null) {
            throw new RuntimeException("Поля 'Название продукта' и 'Дата' не должны быть пустыми");
        }
        List<Order> order = orderRepository.getAllWithoutProductAndDate(productName, date);
        log.debug("Request to get all Orders without product and date: {}, {}", productName, date);
        String log = String.format("Select * from orders where id not in (Select id from order_details \n" +
                "where product_name = '%s') and order_date = '%s'\n\n", productName, date);

        FileOutputStreamUtil.fileOutputStream(log);

        return order.stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }*/
}

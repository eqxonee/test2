package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private String orderNumber;
    private BigDecimal orderSum;
    private Timestamp orderDate;
    private String recipient;
    private String deliveryAddress;
    private String paymentType;
    private String deliveryType;
}

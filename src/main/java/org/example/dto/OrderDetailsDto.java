package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    private Long id;
    private Long productCode;
    private String productName;
    private Integer quantity;
    private BigDecimal unitCost;
    private Long orderId;
}

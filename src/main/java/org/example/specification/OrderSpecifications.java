package org.example.specification;

import org.example.model.Order;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderSpecifications {

    public static Specification<Order> filterByDateAndSum(Timestamp date, BigDecimal sum) {
        return ((root, query, criteriaBuilder) -> {
                if(date == null || sum == null) {
                    return criteriaBuilder.conjunction();
                }
                return root.join("order_date").get("id").in(date, sum);
        });
    }
}

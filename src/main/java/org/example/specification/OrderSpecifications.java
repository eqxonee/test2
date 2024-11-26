package org.example.specification;

import org.example.model.Order;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderSpecifications {

    public static Specification<Order> filterByDate(Timestamp date) {
        return ((root, query, criteriaBuilder) -> {
                if(date == null) {
                    return criteriaBuilder.conjunction();
                }
                return root.join("order_date").in(date);
        });
    }

    public static Specification<Order> filterBySum(BigDecimal sum) {
        return ((root, query, criteriaBuilder) -> {
            if(sum == null) {
                return criteriaBuilder.conjunction();
            }
            return root.join("order_summ").in(sum);
        });
    }
}

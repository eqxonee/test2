package org.example.repository;

import org.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    List<Order> getAllByRecipient(String name);

    @Query(value = "Select * from orders where order_date = :date and order_summ >= :sum", nativeQuery = true)
    List<Order> getAllByDateAndSum(@Param("date") OffsetDateTime date, @Param("sum") BigDecimal sum);

    @Query(value = "Select * from orders where id not in (Select id from order_details "
           + "where product_name = :detailsName) and order_date = :date", nativeQuery = true)
    List<Order> getAllWithoutProductAndDate(@Param("detailsName") String detailsName, @Param("date") OffsetDateTime date);

    boolean existsByOrderNumber(String orderNumber);
}

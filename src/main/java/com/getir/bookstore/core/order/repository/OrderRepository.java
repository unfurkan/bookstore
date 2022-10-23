package com.getir.bookstore.core.order.repository;

import com.getir.bookstore.core.order.model.domain.Order;
import com.getir.bookstore.core.order.model.dto.OrderStatisticsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    //TODO alternative
    @Query("SELECT new com.getir.bookstore.core.order.model.dto.OrderStatisticsDTO(substring(o.createdOn,6,2),count(o),SUM(oi.quantity),SUM(o.totalPrice)) FROM Order o " +
            " JOIN  o.orderItems oi" +
            " where o.customer.id =:customerId" +
            " group by substring(o.createdOn,6,2)" +
            " order by substring(o.createdOn,6,2)")
    List<OrderStatisticsDTO> getOrderStatisticsByCustomerId(Long customerId);


}

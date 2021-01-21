package com.eybilal.orderservice.repository;

import com.eybilal.orderservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

}

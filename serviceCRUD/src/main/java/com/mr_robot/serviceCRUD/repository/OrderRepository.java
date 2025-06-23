package com.mr_robot.serviceCRUD.repository;

import com.mr_robot.serviceCRUD.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

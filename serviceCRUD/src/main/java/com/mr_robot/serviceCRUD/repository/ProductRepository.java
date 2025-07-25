package com.mr_robot.serviceCRUD.repository;

import com.mr_robot.serviceCRUD.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
}

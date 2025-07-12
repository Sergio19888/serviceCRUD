package com.mr_robot.serviceCRUD.repository;

import com.mr_robot.serviceCRUD.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    boolean existsByEmail(String email);
}

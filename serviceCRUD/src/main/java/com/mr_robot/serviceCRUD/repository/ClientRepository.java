package com.mr_robot.serviceCRUD.repository;

import com.mr_robot.serviceCRUD.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
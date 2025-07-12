package com.mr_robot.serviceCRUD.model;

import jakarta.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

}

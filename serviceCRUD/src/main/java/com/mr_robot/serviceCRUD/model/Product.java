package com.mr_robot.serviceCRUD.model;

import jakarta.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "productes")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

}

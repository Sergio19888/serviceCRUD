package com.mr_robot.serviceCRUD.DTO;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClientDTO {

    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surName;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    private String phoneNumber;

}
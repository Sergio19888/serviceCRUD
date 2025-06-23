package com.mr_robot.serviceCRUD.DTO;

import com.mr_robot.serviceCRUD.model.EmployeeRole;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDTO {
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private EmployeeRole role;

}

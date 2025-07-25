package com.mr_robot.serviceCRUD.DTO;

import com.mr_robot.serviceCRUD.model.EmployeeRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(min = 6, message = "Пароль должен быть не менее 6-ти символов")
    @NotBlank
    private String password;


    @NotNull(message = "Роль обязательна, значения \"ADMIN\" или \"MANAGER\"")
    private EmployeeRole role;

}

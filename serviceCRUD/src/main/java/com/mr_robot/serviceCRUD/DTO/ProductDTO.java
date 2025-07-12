package com.mr_robot.serviceCRUD.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private long price;
}

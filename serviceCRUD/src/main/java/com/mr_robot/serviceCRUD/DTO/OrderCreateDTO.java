package com.mr_robot.serviceCRUD.DTO;


import com.mr_robot.serviceCRUD.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderCreateDTO {

    @NotNull
    private Long clientId;
    @NotNull
    private List<Product> productId;
}

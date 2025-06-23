package com.mr_robot.serviceCRUD.DTO;


import com.mr_robot.serviceCRUD.model.Client;
import com.mr_robot.serviceCRUD.model.OrderStatus;
import com.mr_robot.serviceCRUD.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private long id;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private OrderStatus orderStatus;

    @NotNull
    private Client client;

    @NotNull
    private List<Product> productes;
}

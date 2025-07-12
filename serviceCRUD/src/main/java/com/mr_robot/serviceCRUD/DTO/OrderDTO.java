package com.mr_robot.serviceCRUD.DTO;



import com.mr_robot.serviceCRUD.model.OrderStatus;
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
    private ClientDTO client;

    @NotNull
    private List<ProductDTO> products;
}

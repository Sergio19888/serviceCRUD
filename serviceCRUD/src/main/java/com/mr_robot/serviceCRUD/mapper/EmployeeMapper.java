package com.mr_robot.serviceCRUD.mapper;


import com.mr_robot.serviceCRUD.DTO.EmployeeDTO;
import com.mr_robot.serviceCRUD.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}

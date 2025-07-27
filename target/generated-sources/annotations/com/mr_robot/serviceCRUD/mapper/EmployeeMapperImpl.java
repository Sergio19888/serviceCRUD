package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.EmployeeDTO;
import com.mr_robot.serviceCRUD.model.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-25T18:28:39+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setName( employee.getName() );
        employeeDTO.setSurName( employee.getSurName() );
        employeeDTO.setEmail( employee.getEmail() );
        employeeDTO.setPassword( employee.getPassword() );
        employeeDTO.setRole( employee.getRole() );

        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDTO.getId() );
        employee.setName( employeeDTO.getName() );
        employee.setSurName( employeeDTO.getSurName() );
        employee.setEmail( employeeDTO.getEmail() );
        employee.setPassword( employeeDTO.getPassword() );
        employee.setRole( employeeDTO.getRole() );

        return employee;
    }
}

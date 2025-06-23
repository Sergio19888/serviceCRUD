package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.EmployeeDTO;
import com.mr_robot.serviceCRUD.mapper.EmployeeMapper;
import com.mr_robot.serviceCRUD.model.Employee;
import com.mr_robot.serviceCRUD.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Такого сотрудника нет"));
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSurName(employeeDTO.getSurName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setPassword(employeeDTO.getPassword());
        existingEmployee.setRole(employeeDTO.getRole());

        Employee updateEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toDTO(updateEmployee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee pictureEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Такого сотрудника нет"));

        return employeeMapper.toDTO(pictureEmployee);
    }

    public Page<EmployeeDTO> getAllEmployees(String nameFilter, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        Page<Employee> employees;

        if (nameFilter != null && !nameFilter.isEmpty()) {
            employees = employeeRepository.findByNameContainingIgnoreCase(nameFilter, pageable);
        } else {
            employees = employeeRepository.findAll(pageable);
        }

        return employees.map(employeeMapper::toDTO);
    }

}

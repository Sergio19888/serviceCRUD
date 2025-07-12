package com.mr_robot.serviceCRUD.controller;


import com.mr_robot.serviceCRUD.DTO.EmployeeDTO;
import com.mr_robot.serviceCRUD.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO createEmloyee = employeeService.create(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEmloyee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updateEmployee = employeeService.update(id, employeeDTO);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Page<EmployeeDTO>> getAllEmployees(
            @RequestParam(required = false) String nameFilter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<EmployeeDTO> employees = employeeService.getAllEmployees(nameFilter, pageable);
        return ResponseEntity.ok(employees);
    }

}

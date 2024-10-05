package com.klinnovations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klinnovations.entity.Employee;
import com.klinnovations.exception.EmployeeNotFoundException;
import com.klinnovations.exception.EmployeeAlreadyExistsException;
import com.klinnovations.repo.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            throw new EmployeeAlreadyExistsException("Employee already exists with id: " + employee.getId());
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getId())) {
            throw new EmployeeNotFoundException("Employee not found with id: " + employee.getId());
        }
        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(int id) {
        Employee employeeToDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employeeToDelete);
        return employeeToDelete;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}

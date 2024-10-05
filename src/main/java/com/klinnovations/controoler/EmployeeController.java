package com.klinnovations.controoler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klinnovations.entity.Employee;
import com.klinnovations.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController { 
	
	@Autowired
	private EmployeeService employeeService; 

	@PostMapping("/addEmployee") 
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){ 
		return ResponseEntity.ok(employeeService.saveEmployee(employee)); 
	} 
	
	@PutMapping("/updateEmployee") 
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){ 
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		if (updatedEmployee != null) {
			return ResponseEntity.ok(updatedEmployee);
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	
	@DeleteMapping("/deleteEmployee/{id}") 
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){ 
		Employee deletedEmployee = employeeService.deleteEmployee(id);
		if (deletedEmployee != null) {
			return ResponseEntity.ok(deletedEmployee);
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	
	@GetMapping("/getEmployees") 
	public ResponseEntity<List<Employee>> getEmployees(){ 
		return ResponseEntity.ok(employeeService.getEmployees()); 
	} 
}


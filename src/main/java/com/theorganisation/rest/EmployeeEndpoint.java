package com.theorganisation.rest;

import com.theorganisation.controller.EmployeeService;
import com.theorganisation.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeEndpoint {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/new")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/all")
	public Iterable<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@PutMapping("/changesalary/{id}")
	public void changeSalary(@PathVariable(value = "id") long id, @RequestBody Employee emp){
		employeeService.changeSalaryById(id, emp);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable(value = "id") long id){
		employeeService.deleteEmployeeById(id);
	}

	@PutMapping("/addphone/{id}/{phoneid}")
	public void telefoonToEmployee(@PathVariable(value = "id") long empId, @PathVariable(value = "phoneid") long telId){
		employeeService.telefoonToEmployee(empId, telId);
	}
}

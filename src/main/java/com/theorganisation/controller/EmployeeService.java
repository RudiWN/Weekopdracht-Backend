package com.theorganisation.controller;

import com.theorganisation.domain.Employee;
import com.theorganisation.domain.Telefoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;

	@Autowired
	TelefoonRepository telefoonrepository;
	
	public Employee addEmployee(Employee employee) {
		System.out.println("Employee toegevoegd aan database");
		return employeerepository.save(employee);
	}

	public Iterable<Employee> getAllEmployees() {
		System.out.println("inzien alle employees in database");
		return employeerepository.findAll();
	}

	public Employee changeSalaryById(long id, Employee emp) {
		System.out.println("Salaris veranderd!");
		Employee employee = employeerepository.findById(id).get();
		if(emp.getName() != null && emp.getName() != ""){
			employee.setName(emp.getName());
			System.out.println(emp.getName());
		}
		employee.setSalary(emp.getSalary());
		return employeerepository.save(employee);
	}

	public void deleteEmployeeById(long empId){
		System.out.println("Employee deleted!");
		employeerepository.deleteById(empId);
	}

	public Employee telefoonToEmployee(long empId, long telId){
		Employee emp = employeerepository.findById(empId).get();
		Telefoon tel = telefoonrepository.findById(telId).get();
		if(tel.getEmployee() != null){
			Optional<Employee> temp = employeerepository.findById(tel.getEmployee().getId());
			temp.get().setTelefoon(null);
		}
		emp.setTelefoon(tel);
		return employeerepository.save(emp);
	}
}

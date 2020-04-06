package com.Spring.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Modal.Employee;
import com.Spring.Modal.UserDetail;
import com.Spring.Service.EmpolyeeService;
import com.Spring.Service.UserService;

@RestController
public class RequestHandler {

	@Autowired
	EmpolyeeService empolyeeService;
	@Autowired
	UserService userService;

	@PostMapping(value = "/create")
	public boolean create(@RequestBody List<Employee> emp) {
		empolyeeService.createEmployee(emp);
		return true;
	}

	@PostMapping(value = "/create_user")
	public boolean create(@RequestBody UserDetail emp) {
		userService.createUser(emp);
		return true;
	}

	@GetMapping(value = "/getall")
	public Collection<Employee> getAll() {
		return empolyeeService.getAllEmployees();
	}

	@GetMapping(value = "/getbyid/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value = "employee-id") int id) {
		return empolyeeService.findEmployeeById(id);
	}

	@PutMapping(value = "/update/{employee-id}")
	public String update(@PathVariable(value = "employee-id") int id, @RequestBody Employee e) {
		e.setId(id);
		empolyeeService.updateEmployee(e);
		return "Employee record for employee-id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{employee-id}")
	public String delete(@PathVariable(value = "employee-id") int id) {
		empolyeeService.deleteEmployeeById(id);
		return "Employee record for employee-id= " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		empolyeeService.deleteAllEmployees();
		return "All employee records deleted.";
	}

}

package com.Spring.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.Spring.Modal.Employee;

@Component
public interface EmpolyeeService {

	public void createEmployee(List<Employee> emp);

	public Collection<Employee> getAllEmployees();

	public Optional<Employee> findEmployeeById(int id);

	public void deleteEmployeeById(int id);

	public void updateEmployee(Employee emp);

	public void deleteAllEmployees();
}
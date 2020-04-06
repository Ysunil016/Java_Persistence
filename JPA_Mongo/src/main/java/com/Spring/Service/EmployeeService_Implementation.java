package com.Spring.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Dao.EmployeeDao;
import com.Spring.Modal.Employee;

@Service
public class EmployeeService_Implementation implements EmpolyeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void createEmployee(List<Employee> emp) {
		employeeDao.saveAll(emp);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeDao.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.save(emp);
	}

	@Override
	public void deleteAllEmployees() {
		employeeDao.deleteAll();
	}

}

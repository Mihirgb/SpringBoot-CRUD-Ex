package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repositeries.EmployeeRepositeries;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepositeries employeeRepository;
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public String addEmployee(Employee emp) {
		String response;
		if(employeeRepository.addEmployee(emp))
			response = "Added Successfully";
		else
			response = "Failed to add Retry it";
		return response;
	}

	public String updateEmployee(Employee emp) {
		String response;
		if(employeeRepository.updateEmployee(emp))
			response = "Updated Successfully";
		else
			response = "Failed to update! Retry it";
		return response;
	}

	public String deleteEmployee(int id) {
		String response;
		if(employeeRepository.deleteEmployee(id))
			response = "Deleted Blog Successfully";
		else
			response = "Failed to Delete Blog! Retry it";
		return response;
	}

	public List<Employee> getbyID(int id) {
		return employeeRepository.get_d_ID(id);
	}



}

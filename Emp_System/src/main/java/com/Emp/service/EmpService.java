package com.Emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp.entity.Employee;
import com.Emp.repository.EmpRepo;

@Service
public class EmpService {

	  @Autowired
	  private EmpRepo empRepo;
	  
	public void addEmp(Employee e) {
		empRepo.save(e);
	}
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
	public Optional<Employee> getEmployee(int id) {
		Optional<Employee> e = empRepo.findById(id);
		if (e.isPresent()) {
			return Optional.of(e.get());
		}
		return null;
	}
	public void deletId(int id) {
		empRepo.deleteById(id);
	}
}

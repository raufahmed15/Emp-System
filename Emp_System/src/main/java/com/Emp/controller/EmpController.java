package com.Emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Emp.entity.Employee;
import com.Emp.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;

	 @GetMapping("/")
	 public String home(Model model) {
		 List<Employee> employees = service.getEmployees();
		 model.addAttribute("emp",employees);
		 return "index";
	 }
	 
	 @GetMapping("/addemp")
	 public String Add() {
		 return "addemp";
	 }
	 
	 @PostMapping("/register")
	 public String EmpRegister(@ModelAttribute Employee e,RedirectAttributes attributes) {
		 service.addEmp(e);
		 System.out.println(e);
		 attributes.addFlashAttribute("msg", "added successfully");
		 return "redirect:/";
	 }
	 
	 @GetMapping("/edit/{id}")
	 public String edit(@PathVariable int id, Model model) {
		 Optional<Employee> employee = service.getEmployee(id);
		 model.addAttribute("e", employee);
		 return "edit";
	 }
	 
	 @PostMapping("/update")
	 public String update(@ModelAttribute Employee employee,RedirectAttributes attributes) {
		 service.addEmp(employee);
		 attributes.addFlashAttribute("msg", "Upate successfully");
		 return "redirect:/";
	 }
	 
	 @GetMapping("/delete/{id}")
	 public String deleteEmp(@PathVariable int id, RedirectAttributes attributes) {
		 service.deletId(id);
		 attributes.addFlashAttribute("msg", "Delete successfully");
		 return "redirect:/";
	 }
	 
}

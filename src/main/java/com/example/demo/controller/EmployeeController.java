package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.util.UploadHelper;
@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeController{
	
	@Autowired
	private UploadHelper uploadHelper;

	@Autowired
	private EmployeeRepository  employeeRepository;
	
	@GetMapping("/")
	public List<Employee>  getlAlEmployee()
	{
		return employeeRepository.findAll();
	}
	
	@PostMapping("/")
	public  Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeBId(@PathVariable("id") int id)
	{
		return employeeRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void Employee(@PathVariable("id") int id)
	{
		 employeeRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public  Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id)
	{
		employee.setId(id);
		return employeeRepository.save(employee);
	}
	
	@PostMapping("/upload/{id}")
	public void uplaodImage(@RequestParam("imageFile") MultipartFile file,@PathVariable("id") int id) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("Reached To upload ");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		
		if(file.isEmpty())
		{
				System.out.println("Select File");
		}
		
	boolean status=	uploadHelper.upload(file);
	
	if(status)
	{
		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());

		String imgUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString();
		Employee emp = employeeRepository.getById(id);
		emp.setImageUrl(imgUrl);
		employeeRepository.save(emp);
		System.out.println("Image url saved");
	}
	
	}

		
		
	}
	
	
	



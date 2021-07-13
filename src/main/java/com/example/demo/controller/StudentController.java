package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") int id )
	{
		return studentRepository.findById(id).get();
	}
	
	@PostMapping("/")
	public Student saveStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id)
	{
		return studentRepository.save(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id )
	{
		 studentRepository.deleteById(id);
	}
	
}

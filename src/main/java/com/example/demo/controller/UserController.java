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

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/")
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id )
	{
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user )
	{
		return userRepository.save(user);
	}
	
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id )
	{
		user.setId(id);
		return userRepository.save(user);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id )
	{
		 userRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
}

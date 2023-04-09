package com.saif.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saif.entity.User;

@RestController
@RequestMapping("/user/")
public class UserController {

	static List<User> userList=null;
	static{
		userList=new ArrayList<User>();
	}
	
	@PostMapping(value="add")
	public  User addUser(@RequestBody User user){
		userList.add(user);
		return user;
	}
	@GetMapping(value="get/{userId}")
	public User getUser(@PathVariable String userId){
		User user=null;
		for(User student:userList){
			if (student.getUserId()==Integer.parseInt(userId)) 
				user=student;
		}
		return user;
	}
	@GetMapping(value="getAllUsers")
	public List<User> getAllUsers(){
		return userList;
	}
	
	
}

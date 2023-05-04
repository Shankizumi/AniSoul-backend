package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Users;

@Service
public class UsersDao {
	
@Autowired
UsersRepository userRepository;

//method to fetch the data from database
 public List<Users> getAllEmployees(){
	 return userRepository.findAll();
 }
 
 //method to store the data in database
 public Users insert(Users user){
	 return userRepository.save(user);
 }
 public Users log(String userName,String password ){
	 System.out.println(userName);
	 System.out.println(password);
	 
	 return userRepository.login(userName, password);
 }

}


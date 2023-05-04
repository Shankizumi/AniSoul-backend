package com.ts.anisoul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UsersDao;
import com.dto.Users;


@RestController
public class UsersController {
	@Autowired
	UsersDao usersDao;
	@CrossOrigin(origins = "http://localhost:4200")
	
	// request method to fetch data from database
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers(){
		return usersDao.getAllEmployees();
	}
	
	//request mothod to store the data in databse
	@PostMapping("/registration")
	public Users registration(@RequestBody Users user ){
		 String EmailID=user.getEmailId();
		 System.out.println(EmailID);
		 String subj="registration";
		 String message="welcome to anisoul";
	
		 EmailService.sendEmail(message,subj,EmailID,"mohdkaif6371@gmail.com");
		
		return usersDao.insert(user);
		
	}
	// get user by username and EmailID
	@GetMapping("/login/{userName}/{password}")
	public Users login(@PathVariable("userName") String userName, @PathVariable("password") String password) {
	    return usersDao.log(userName, password);
	}

}


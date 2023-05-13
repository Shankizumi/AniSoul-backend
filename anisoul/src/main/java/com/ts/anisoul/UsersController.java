package com.ts.anisoul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.SmsService;
import com.dao.UsersDao;
import com.dto.Users;

@RestController
public class UsersController {
	 private static final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	 @Autowired
	 private SmsService smsService;

	  
	@Autowired
	UsersDao usersDao;
	
	// request method to fetch data from database
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers(){
		return usersDao.getAllEmployees();
	}
	
	@GetMapping("getUserByUserName/{UserName}")
	public Users getUserByUserName(@PathVariable("UserName") String UserName){
		return usersDao.getUserByUserName(UserName);
	}
	//request mothod to store the data in databse
	@PostMapping("/registration")
	public Users registration(@RequestBody Users user ){
		Users user2=null;
		boolean flag2=true;
	
		try{
		 String EmailID=user.getEmailId();
		 System.out.println(EmailID);
		 String subj="registration";
		 String message="welcome to anisoul";
		
		 Users user1=new Users(user.getFullName(),user.getEmailId(),user.getPhoneNo(),user.getUserName(),user.getencodedPassword());
		
		user2=usersDao.insert(user1); 
		EmailService.sendEmail(message,subj,EmailID,"mohdkaif6371@gmail.com");
		 
		}
		catch(Exception e){
			e.printStackTrace();
			flag2=false;
			
		}
		if(flag2){
			return user2;
		}
		else{
			
			return null;
		}
		
		}
	
	@PutMapping("/updateProfile") 
	public Users updateProfile(@RequestBody Users user){
		return usersDao.insert(user);
	}
	
	@GetMapping("/login/{userName}/{password}")
	public boolean userAuthentication (@PathVariable("userName") String userName, @PathVariable("password") String password) {
		String encodedPassword =usersDao.userAuthentication(userName);
	    return pwEncoder.matches(password, encodedPassword);
	    		
	}
	@GetMapping("/send-sms/{phoneNo}")
    public int sendSMS(@PathVariable("phoneNo") String phoneNo) {
		
    	int min=100000;
    	int max=999999;
    	int otp=(int)(Math.random()*(max-min+1)+min);
    	String msg="your OTp is"+otp+"please verify this in your application";
    	System.out.println(otp);
    	
      String s=  smsService.sendSMS(phoneNo, msg);
      if(s!=null){
    	  return otp;
      }
      else{
    	  return 0;
      }
    }
	
	@PutMapping("/updatePass")
	public int updatPass(@RequestBody Users user1){
		String phoneNo=user1.getPhoneNo();
		String password=user1.getencodedPassword();	
		System.out.println(phoneNo);
		System.out.println(password);
		return usersDao.setPass(phoneNo, password);
		
	}
	
	@GetMapping("/sendOTPByEmail/{emailId}")
	public int sendOTPByEmail(@PathVariable("emailId") String emailId){
		int min=100000;
    	int max=999999;
    	int otp=(int)(Math.random()*(max-min+1)+min);
    	String msg="your OTp is  " +otp+ "  please verify this in your application";
    	System.out.println(otp);
    	String subj="otp service";
    	boolean flag= EmailService.sendEmail(msg,subj,emailId,"mohdkaif6371@gmail.com");
    	if(flag){
    		return otp;
    	}
    	else{
    		return 0;
    	}
   
}
	@PutMapping("/updateNewPass")
	public int  newPass(@RequestBody Users user1){
		String emailId=user1.getEmailId();
		String password=user1.getPassword();	
		
		
		return usersDao.setNewPass(emailId, password);
		
	}
	
}



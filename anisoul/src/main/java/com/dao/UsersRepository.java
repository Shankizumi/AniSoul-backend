package com.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dto.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	@Query(" select e.password from Users e where e.userName = :userName ")

	public String userAuthentication(@Param("userName") String userName); 
		@Query(" from Users e where e.userName = :userName ")
	public Users userByUserName(@Param("userName")  String userName);
	
	@Transactional
	@Modifying
    @Query("UPDATE Users e SET e.password = :password WHERE e.phoneNo = :phoneNo")
	public int updatePass(@Param("phoneNo") String phoneNo,@Param("password") String passowrd);
//    @Query("UPDATE Users e SET e.password = :password WHERE e.userid = :userid")
//	public int updatePass(@Param("password") String passowrd,@Param("userid") String userid);

}


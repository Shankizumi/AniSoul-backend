package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	@Query(" select e.password from Users e where e.userName = :userName ")
	public String userAuthentication(@Param("userName") String userName);
	
	
	
}


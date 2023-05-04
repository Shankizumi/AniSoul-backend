package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	@Query("from Users e where e.userName = :userName and e.password = :password")
	public Users login(@Param("userName") String userName, @Param("password") String password);
}


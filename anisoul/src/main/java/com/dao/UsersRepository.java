package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}


package com.example.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.User;


public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByUsername(String userName);
}

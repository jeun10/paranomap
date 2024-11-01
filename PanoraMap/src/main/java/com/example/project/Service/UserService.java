package com.example.project.Service;

import org.springframework.stereotype.Service;

import com.example.project.Dto.LoginDto;
import com.example.project.Dto.UserDto;
import com.example.project.Entity.User;

@Service
public interface UserService {
	User saveEntity(User user);
	User saveDto(UserDto userdto);
	User findByUsername(String userName);
	boolean login(LoginDto logindto);
}

package com.example.project.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.Dto.LoginDto;
import com.example.project.Dto.UserDto;
import com.example.project.Entity.User;
import com.example.project.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public User saveEntity(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User saveDto(UserDto userdto) {
		// TODO Auto-generated method stub
		User user= User.builder()
        .userId(userdto.getUserId())
        .userpw(userdto.getUserpw())
        .username(userdto.getUsername())
        .useremail(userdto.getUseremail())
        .build(); 
		
		return saveEntity(user);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}
	
	public boolean login(LoginDto logindto) {
		String username=logindto.getUsername();
		String userpw=logindto.getUserpw();
		User byUsername=userRepository.findByUsername(username);
		if(byUsername!=null) {
			if(byUsername.getUserpw().equals(userpw)) {
				return true;
			}
			
		}
		return false;
	}
	
	
}

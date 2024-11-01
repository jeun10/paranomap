package com.example.project.Dto;


import com.example.project.Entity.User;

import lombok.Data;

@Data
public class UserDto {
	private Long userId;
    private String userpw;
    private String username;
    private String useremail;

    public User toEntity() {
		return User.builder()
				.userId(userId)
				.username(username)
				.userpw(userpw)
				.useremail(useremail)
				.build();
    	
    }
 
}

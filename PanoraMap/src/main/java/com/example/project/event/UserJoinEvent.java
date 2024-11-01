package com.example.project.event;

import org.springframework.context.ApplicationEvent;

import com.example.project.Entity.User;

public class UserJoinEvent extends ApplicationEvent {
	private User user;
	
	public UserJoinEvent(User user) {
		super(user);
		this.user=user;
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}

}

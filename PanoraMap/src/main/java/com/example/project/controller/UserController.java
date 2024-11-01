package com.example.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerErrorException;

import com.example.project.Dto.LoginDto;
import com.example.project.Dto.UserDto;
import com.example.project.Entity.User;
import com.example.project.Service.UserService;
import com.example.project.event.UserJoinEvent;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;
	private final ApplicationEventPublisher eventPublisher;
	
	@GetMapping("/joinUser")
	public String joinUser(Model model) {
		model.addAttribute("user", new UserDto());
		return "user/joinUser";
	}

	@PostMapping("/joinUser")
	public String joinUser(UserDto userdto) {
		
		log.info("userDto:{}",userdto);
		userService.saveDto(userdto);
		return "redirect:/";
	}

}

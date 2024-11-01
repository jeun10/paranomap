package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project.Entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@GetMapping("/mainBoard")
	public String mainBoard(Model model, HttpSession session) {
		/*
		 * User loginUser = (User) session.getAttribute("loginUser");
		 * 
		 * model.addAttribute("loginUser", loginUser);
		 */
		return "/board/mainBoard";
	}
}

package com.example.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.Entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
 
    
    @GetMapping("/")
    public String home(Model model, HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");

        model.addAttribute("loginUser", loginUser);
        return "home";
    }
}

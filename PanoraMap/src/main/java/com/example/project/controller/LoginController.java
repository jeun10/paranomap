package com.example.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project.Dto.LoginDto;
import com.example.project.Entity.User;
import com.example.project.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class LoginController {
	
	private final UserService userService;
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/login")
	public String getLogin(HttpServletRequest request, Model model) {
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("prevPage", referer);
		log.info("uri={}",referer);
		model.addAttribute("login",new LoginDto());
		
		return "user/login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute("login") LoginDto loginDto,HttpServletRequest request, HttpSession session,Model model) {
	    
		boolean login = userService.login(loginDto);

        if (login){
            String username = loginDto.getUsername();
            User user = userService.findByUsername(username);
            session.setAttribute("loginUser",user);

            //저장한 이전페이지 주소를 가져온다
            String prevPage = (String) request.getSession().getAttribute("prevPage");
            //세션에 페지이 주소 삭제
            request.getSession().removeAttribute("prevPage");

            return "redirect:" + (prevPage != null ? prevPage : "/");       //이전페이지가 있다면 이전페이지로 없다면 / 페이지로

        }

        model.addAttribute("error", "비밀번호 또는 아이디가 올바르지 않습니다.");
		
		return "user/login";
	}
	@PostMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginMember");
        return "redirect:/";
	}
}

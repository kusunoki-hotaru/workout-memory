package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	//ログイン画面を表示
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}

	@PostMapping("/workout")
		public String postLogin() {
		
			return "workout/workoutList";
		}
	
}

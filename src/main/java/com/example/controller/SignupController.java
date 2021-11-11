package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.WUser;
import com.example.domain.service.UserService;
import com.example.form.SignupForm;
import com.example.service.UserApplicationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/signup")
	public String getSignup(Model model,Locale locale,@ModelAttribute SignupForm form) {
		
		//性別を取得
		Map<String,Integer> genderMap = userApplicationService.getGenderMap();
		
		model.addAttribute("genderMap",genderMap);
		
		return "user/signup";
	}
	
	//ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup(Model model,Locale locale,@ModelAttribute @Validated SignupForm form,BindingResult bindingResult) {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {
			return getSignup(model,locale,form);
		}
		
		log.info(form.toString());
		
		//formをWUserクラスに変換
		WUser user = modelMapper.map(form,WUser.class);
		
		//ユーザー登録
		userService.signup(user);
		//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}

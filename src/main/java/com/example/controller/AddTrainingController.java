package com.example.controller;

import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.WEntity;
import com.example.domain.service.WorkoutService;
import com.example.form.WorkoutForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AddTrainingController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/addTraining")
	public String getAddTraining(Model model,Locale locale,@ModelAttribute WorkoutForm wform) {
		
		return "workout/addTraining";
	}

	@PostMapping("/addTraining")
		public String postAddTraining(Model model,Locale locale,@ModelAttribute @Validated 
				                      WorkoutForm wform,BindingResult bindingResult) {
		
		//エラーだったら登録しない
		if(bindingResult.hasErrors()) {
			
			return getAddTraining(model,locale,wform);
		}
		
		log.info(wform.toString());
		
		WEntity WE = modelMapper.map(wform,WEntity.class);
		
		workoutService.addTraining(WE);
		
			return "redirect:/list";
		}
	
	
	//データベース関連の例外処理
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e,Model model) {
		
		//空文字をセット
		model.addAttribute("error","");
		
		//メッセージをModelに登録
		model.addAttribute("message","AddTrainingControllerで例外が発生しました");
		
		//HTTPのエラーコード（５００）をModelに登録
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
	
		return "error";
	}
	
	//その他の例外処理
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e,Model model) {
		
		//空文字セット
		model.addAttribute("error","");
		
		//メッセージをModelに登録
		model.addAttribute("message","AaddTrainingControllerで例外が発生しました");
		
		//HTTPのエラーコード（５００）をModelに登録
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
	}
	
	
	
	
	
	
	
	
}

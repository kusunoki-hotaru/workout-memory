package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.WUser;
import com.example.domain.service.WorkoutService;
import com.example.form.WorkoutForm;

@Controller
public class WorkoutListController {
	
	@Autowired
	private WorkoutService userService;

	@GetMapping("/workout")
	public String getWorkoutList(Model model,@ModelAttribute WorkoutForm wform){
		
		List<WUser> workoutList = userService.getWorkout();
		
	    //リスト取得
		model.addAttribute("workoutList",workoutList);
		
		return "workout/workoutList";
	}
	@PostMapping
	public String postWorkoutList(@ModelAttribute WorkoutForm wform) {
		
		
		return "workout/workoutList";
	}
	
}

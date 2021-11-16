package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.WEntity;
import com.example.domain.service.WorkoutService;

@Controller

public class WorkoutListController {
	
	@Autowired
	private WorkoutService workoutService;

	@GetMapping("/list")
	public String getWorkoutList(Model model){
		
		List<WEntity> workoutList = workoutService.getWorkout();
		
	    //リスト取得
		model.addAttribute("workoutList",workoutList);
		
		return "workout/workoutList";
	}
	
	
}

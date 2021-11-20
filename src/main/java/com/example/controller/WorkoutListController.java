package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.WEntity;
import com.example.domain.service.WorkoutService;
import com.example.form.WorkoutListForm;

@Controller

public class WorkoutListController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/list")
	public String getWorkoutList(@ModelAttribute WorkoutListForm form, Model model){
		
		WEntity WE = modelMapper.map(form,WEntity.class);
		
		List<WEntity> workoutList = workoutService.getWorkout(WE);
		
	    //リスト取得
		model.addAttribute("workoutList",workoutList);
		
		return "workout/workoutList";
	}
	
	 //検索処理
    @PostMapping("/list")
    public String postWorkoutList(@ModelAttribute WorkoutListForm form,Model model) {
    	
    	WEntity WE = modelMapper.map(form,WEntity.class);
    	
    	List<WEntity> workoutList = workoutService.getWorkout(WE);
    	
    	model.addAttribute("workoutList",workoutList);
    	
    	return "workout/workoutList";
    }
	
}

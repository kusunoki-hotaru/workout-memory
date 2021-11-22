package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.model.WEntity;
import com.example.domain.service.WorkoutService;
import com.example.form.WorkoutDetailForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WorkoutDetailController {

	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/workoutDetail/{training}")
	public String getTraining(WorkoutDetailForm WDForm,Model model,
			                  @PathVariable("training")String training) {
	
		WEntity WE =workoutService.getWorkoutOne(training);
		       
		
		WDForm = modelMapper.map(WE,WorkoutDetailForm.class);
		WDForm.setMemoryList(WE.getMemoryList());
		
		model.addAttribute("WDForm",WDForm);
		
		return"workout/detail";
	}
	
	//更新処理
	@PostMapping(value ="/workoutDetail",params = "update")
	public String updateWorkout(WorkoutDetailForm form,Model model) {
		
		try {
		workoutService.updateWorkoutOne(form.getTraining(),
				                        form.getBodyParts());
		}catch(Exception e) {
			log.error("エラー",e);
		}
		return "redirect:/list";
	}
	
	
	
	//削除処理
	@PostMapping(value ="/workoutDetail",params = "delete")
	public String deleteWorkout(WorkoutDetailForm form,Model model) {
		
		workoutService.deleteWorkoutOne(form.getTraining());
		
		return "redirect:/list";
	}
	
	
}

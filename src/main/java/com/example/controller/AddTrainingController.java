package com.example.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.WorkoutForm;

@Controller
public class AddTrainingController {
	
	@GetMapping("/addTraining")
	public String getAddTraining(Model model,@ModelAttribute WorkoutForm wform) {
		
		return "workout/addTraining";
	}

	@PostMapping("/addTrainig")
		public String postAddTraining(Model model,@ModelAttribute @Validated WorkoutForm wform,BindingResult bindingResult) {
		
		//エラーだったら更新しない
		if(bindingResult.hasErrors()) {
			return getAddTraining(model,wform);
		}
		
			return "workout/workoutList";
		}

}

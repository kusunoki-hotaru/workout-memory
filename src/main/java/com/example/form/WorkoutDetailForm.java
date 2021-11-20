package com.example.form;

import com.example.domain.model.TrainingMethod;

import lombok.Data;

@Data
public class WorkoutDetailForm {

	private String training;
	
	private String bodyParts;
	
	private TrainingMethod wMemory;
}

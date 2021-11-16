package com.example.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class WorkoutForm {

	@NotBlank
	private String training;
	
	@NotBlank
	private String bodyParts;
}

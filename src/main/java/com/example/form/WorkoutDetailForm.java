package com.example.form;

import java.util.List;

import com.example.domain.model.Memory;
import com.example.domain.model.TMethod;

import lombok.Data;

@Data
public class WorkoutDetailForm {

	private String training;
	
	private String bodyParts;
	
	private TMethod tMethod;
	
	private List<Memory> memoryList;
}

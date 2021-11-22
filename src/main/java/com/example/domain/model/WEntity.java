package com.example.domain.model;


import java.util.List;

import lombok.Data;

@Data
public class WEntity {

	private String training;
	
	private String bodyParts;
	
	private TMethod tMethod;
	
	private List<Memory> memoryList;
}

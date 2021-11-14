package com.example.domain.service;

import java.util.List;

import com.example.domain.model.WEntity;
import com.example.domain.model.WUser;

public interface WorkoutService {

	public void addTraining(WEntity entity);
	
	public List<WUser> getWorkout();
}

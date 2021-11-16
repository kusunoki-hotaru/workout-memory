package com.example.domain.service;

import java.util.List;

import com.example.domain.model.WEntity;

public interface WorkoutService {

	public void addTraining(WEntity entity);
	
	public List<WEntity> getWorkout();
}

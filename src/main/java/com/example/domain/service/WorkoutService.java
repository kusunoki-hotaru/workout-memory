package com.example.domain.service;

import java.util.List;

import com.example.domain.model.WEntity;

public interface WorkoutService {

	public void addTraining(WEntity entity);
	
	public List<WEntity> getWorkout(WEntity entity);
	
	public WEntity getWorkoutOne(String training);
	
	//更新
	public void updateWorkoutOne(String training,String bodyParts);
	
	//削除
	public void deleteWorkoutOne(String training);
}

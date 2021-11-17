package com.example.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.WEntity;
import com.example.domain.service.WorkoutService;
import com.example.repository.WorkoutMapper;

@Service
public class WorkoutServiceImpl implements WorkoutService{

	@Autowired
	private WorkoutMapper mapper;
	
	/** ユーザー登録*/
	@Override
	public void addTraining(WEntity entity) {
		
		mapper.insertOne(entity);
	}
	
	/**ユーザー取得*/
	@Override
	public List<WEntity> getWorkout(){
		return mapper.findMany();
	}
	
	/***/
	@Override
	public WEntity getWorkoutOne(String training) {
		
		return mapper.findOne(training);
	}
	
	//一件更新
	@Override
	public void updateWorkoutOne(String training,String bodyParts) {
		mapper.updateOne(training, bodyParts);
	}
	
	//一件削除
	@Override
	public void deleteWorkoutOne(String training) {
		int count = mapper.deleteOne(training);
	}
	
}

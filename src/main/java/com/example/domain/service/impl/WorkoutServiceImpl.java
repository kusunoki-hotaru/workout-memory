package com.example.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.WEntity;
import com.example.domain.model.WUser;
import com.example.domain.service.WorkoutService;
import com.example.repository.UserMapper;

@Service
public class WorkoutServiceImpl implements WorkoutService{

	@Autowired
	private UserMapper mapper;
	
	/** ユーザー登録*/
	@Override
	public void addTraining(WEntity entity) {
		
		mapper.insertOne(entity);
	}
	
	/**ユーザー取得*/
	@Override
	public List<WUser> getWorkout(){
		return mapper.findMany();
	}
}

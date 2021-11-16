package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.WEntity;


@Mapper
public interface WorkoutMapper {

	public int insertOne(WEntity entity);
	
	public List<WEntity> findMany();
	
	
}

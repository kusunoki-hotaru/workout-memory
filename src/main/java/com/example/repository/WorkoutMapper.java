package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.model.WEntity;


@Mapper
public interface WorkoutMapper {

	public int insertOne(WEntity entity);
	
	public List<WEntity> findMany(WEntity entity);
	
	public WEntity findOne(String training);
	
	public void updateOne(@Param("training")String training,@Param("bodyParts")String bodyParts);
	
	public int deleteOne(@Param("training")String training);
	
}

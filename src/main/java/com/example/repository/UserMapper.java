package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.WEntity;
import com.example.domain.model.WUser;

@Mapper
public interface UserMapper {

	public int insertOne(WEntity entity);
	
	public List<WUser> findMany();
}

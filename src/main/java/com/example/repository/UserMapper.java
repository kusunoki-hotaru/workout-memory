package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.WUser;

@Mapper
public interface UserMapper {

	public int insertOne(WUser user);
}

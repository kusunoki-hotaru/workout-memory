package com.example.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.WUser;
import com.example.domain.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	/** ユーザー登録*/
	@Override
	public void signup(WUser user) {
		
		mapper.insertOne(user);
	}
}

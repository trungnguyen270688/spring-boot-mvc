package com.asiantech.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiantech.application.entity.UserEntity;
import com.asiantech.application.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userDao;
	
	@Override
	public UserEntity save(UserEntity userEntity) {
		return userDao.save(userEntity);
	}

}

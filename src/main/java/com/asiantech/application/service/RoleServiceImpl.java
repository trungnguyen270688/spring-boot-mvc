package com.asiantech.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiantech.application.entity.RoleEntity;
import com.asiantech.application.repository.RoleRepository;

@Component
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleDao;
	
	@Override
	public RoleEntity save(RoleEntity roleEntity) {
		return roleDao.save(roleEntity);
	}


}

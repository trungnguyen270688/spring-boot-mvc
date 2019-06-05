package com.asiantech.application.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.asiantech.application.entity.BookEntity;
import com.asiantech.application.entity.RoleEntity;
import com.asiantech.application.entity.UserEntity;
import com.asiantech.application.service.BookService;
import com.asiantech.application.service.RoleService;
import com.asiantech.application.service.UserService;

@Component
public class DataInit implements ApplicationRunner {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BookService bookService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		roleService.save(new RoleEntity(1l, "ADMIN"));
		roleService.save(new RoleEntity(2l, "USER"));
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(1l);
		
		userService.save(new UserEntity("trung", "trung@gmail.com", passwordEncoder.encode("1234"), roleEntity, new Date()));
		
//		for (int i = 0; i < 100; i++) {
//			bookService.save(new BookEntity("Title "+ (i + 1),"Author "+ (i + 1),"description "+ (i + 1),  new Date(), null));
//		}
	}
}

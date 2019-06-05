package com.asiantech.application.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiantech.application.entity.UserEntity;
import com.asiantech.application.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	private static String DEFAULT_ROLE = "GUEST";

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userDao.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
		return new User(user.getEmail(), user.getPassword(), getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(UserEntity user) {
		String[] userRoles = new String[1];
		userRoles[0] = null!= userRoles ? user.getRole().getName(): DEFAULT_ROLE;
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
}

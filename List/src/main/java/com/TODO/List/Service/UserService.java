package com.TODO.List.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.TODO.List.Entity.Login;
import com.TODO.List.Entity.User;

public interface UserService {

	
	public Login saveLogin(Login s);
	public User saveUser(User u);
	public List<User> findAll();
	public Optional<User> updateUser(Long id);
}

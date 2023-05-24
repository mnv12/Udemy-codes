package com.TODO.List.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.TODO.List.Dao.LoginRepo;
import com.TODO.List.Dao.UserRepo;
import com.TODO.List.Entity.Login;
import com.TODO.List.Entity.User;

import jakarta.persistence.Query;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private LoginRepo login;
	@Autowired
	private UserRepo user;

	@Override
	public Login saveLogin(Login s) {

		return login.save(s);
	}

	@Override
	public User saveUser(User u) {
		// date
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.format(date);
		String log = date.toString();
		u.setLastSeen(log);

		return user.save(u);
	}

	@Override
	public List<User> findAll() {

		return user.findAllByOrderByLastSeenDesc();
	}

	



	@Override
	public Optional<User> updateUser(Long id) {
	
		return user.findById(id);
	}
}

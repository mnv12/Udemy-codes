package com.TODO.List.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TODO.List.Entity.User;
@Repository("userRepo")

public interface UserRepo extends JpaRepository<User, Long> {

	
	public List<User> findAllByOrderByLastSeenDesc();
	
	
}

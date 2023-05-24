package com.TODO.List.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TODO.List.Entity.Login;
@Repository("loginRepo")

public interface LoginRepo extends JpaRepository<Login, Long> {

}

package com.kodnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}

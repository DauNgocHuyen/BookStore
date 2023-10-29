package com.quynhanh.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "Select * from user where email = ?1 and password = ?2", nativeQuery = true)
	User checkLogin(String email, String password);
}

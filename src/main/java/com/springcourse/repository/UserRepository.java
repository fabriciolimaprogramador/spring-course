package com.springcourse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailAndPassword(String email, String password);
	
	@Query("SELECT * FROM USER WHERE EMAIL = ?1 AND PASSWORD = ?2")
	Optional<User> login(String email, String password);

}

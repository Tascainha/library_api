package com.library.api.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> { 
	@Query("SELECT u FROM User u WHERE u.email = :email")
	Optional<User> findByEmail(String email);
}


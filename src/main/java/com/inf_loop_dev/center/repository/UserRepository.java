package com.inf_loop_dev.center.repository;

import com.inf_loop_dev.center.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String userEmail);
}

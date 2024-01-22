package com.devsuperior.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.userdept.entities.User;

// Interface que estende JpaRepository para operações CRUD em User
public interface UserRepository extends JpaRepository<User, Long> {
}

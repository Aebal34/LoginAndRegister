package com.Utopia.Joren.LoginAndRegister.Repositories;

import com.Utopia.Joren.LoginAndRegister.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

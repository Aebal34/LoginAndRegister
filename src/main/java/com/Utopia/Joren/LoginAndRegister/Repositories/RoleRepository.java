package com.Utopia.Joren.LoginAndRegister.Repositories;

import com.Utopia.Joren.LoginAndRegister.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}

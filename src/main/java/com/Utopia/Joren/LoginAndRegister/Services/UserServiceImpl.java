package com.Utopia.Joren.LoginAndRegister.Services;

import com.Utopia.Joren.LoginAndRegister.Models.Role;
import com.Utopia.Joren.LoginAndRegister.Models.User;
import com.Utopia.Joren.LoginAndRegister.Repositories.RoleRepository;
import com.Utopia.Joren.LoginAndRegister.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        User user1 = new User();

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());

        //Encrypt password with spring security
        user1.setPassword(passwordEncoder.encode((user.getPassword())));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user1);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //NEED TO IMPLEMENT USERDTO
}

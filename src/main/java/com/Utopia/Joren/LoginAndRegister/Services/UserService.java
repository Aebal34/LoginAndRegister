package com.Utopia.Joren.LoginAndRegister.Services;

import com.Utopia.Joren.LoginAndRegister.Models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();
}

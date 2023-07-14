package com.Utopia.Joren.LoginAndRegister.Services;

import com.Utopia.Joren.LoginAndRegister.Dto.UserDto;
import com.Utopia.Joren.LoginAndRegister.Models.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

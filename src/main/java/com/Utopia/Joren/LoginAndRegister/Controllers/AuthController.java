package com.Utopia.Joren.LoginAndRegister.Controllers;

import com.Utopia.Joren.LoginAndRegister.Dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    //handler to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    //handler to handle register form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        //create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
}

package pl.ykom.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ykom.core.services.UserService;
import pl.ykom.dto.UserDTO;

@Controller
@RequestMapping("/userLogin")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/showLoginPage")
    public String loginPage(){
        return "login-page";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("newUser", userDTO);
        return "register-page";
    }

    //k
    @PostMapping("/registerUser")
    public void registerUser(@ModelAttribute("newUser") UserDTO userDTO){
        userService.saveUser(userDTO);
    }
}

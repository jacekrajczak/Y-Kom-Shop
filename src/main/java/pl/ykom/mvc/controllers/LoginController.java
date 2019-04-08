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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping
public class LoginController {


    private UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/login")
    public String prepareLoginPage(){
        return "login-page";
    }

    @PostMapping("/login")
    public void login(String login, String password, HttpSession session, HttpServletResponse response) throws IOException {
        boolean validCredentials = userService.checkCredentials(login, password);
        if (!validCredentials) {
            response.sendError(401, "Błędne dane logowania");
            return;
        }
        /*UserDTO user = userService.getUser(login, password);
        session.setAttribute("user", user);
        response.sendRedirect("/");*/
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

package project.photoGallery.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.photoGallery.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    private String logUser(@RequestParam String login, @RequestParam String password, HttpSession session, Model model, HttpServletRequest request) {
        try{
            userService.loadUserByUserLogin(login,password,session);
            return "redirect:" +request.getContextPath()+ "/home";
        }catch (UsernameNotFoundException | LoginException e){
            return "/login";
        }
    }
}

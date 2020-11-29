package project.photoGallery.controller;

import org.apache.catalina.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    /**
     * home page
     * @return home page
     */
    @RequestMapping("photogallery")
    public String home (Model model){

        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name",principal);
        return "photogallery";
    }
}



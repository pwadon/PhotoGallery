package project.photoGallery.controller;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.photoGallery.service.HomeService;



@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {

    HomeService homeService;
    /**
     * home page
     * @return home page
     */
    @RequestMapping("photogallery")
    public String home (Model model){
        homeService.addPhotosAndNameToView(model);
        return "photogallery";
    }
}



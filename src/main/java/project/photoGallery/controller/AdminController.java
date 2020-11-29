package project.photoGallery.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.User;
import project.photoGallery.repository.GalleryRepository;
import project.photoGallery.repository.UserRepository;
import project.photoGallery.service.AdminService;


@Controller
@AllArgsConstructor
@RequestMapping("/photogallery")
public class AdminController {

    private AdminService adminService;
    private UserRepository userRepository;
    private GalleryRepository galleryRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping(value ="/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping(value ="/admin/users")
    public String addUser(Model model){
        adminService.addUser(model);
//        adminService.getListOfUsersToDelete(model,userRepository);

        return "adminAddUser";
    }

    @PostMapping(value ="/admin/users")
    public String addUser(@ModelAttribute("user") User user, Model model){
        if(userRepository.findByLogin(user.getLogin())!=null){
            model.addAttribute("message","User with such login already exists");
            return "adminAddUserResult";
        }

        String hashedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPass);
        userRepository.save(user);
        model.addAttribute("message","Adding user Was succesfull");
        return "adminAddUserResult";
    }

    @GetMapping(value ="/admin/galleries")
    public String addGallery(Model model){
        adminService.addGallery(model);
        adminService.listOfUsers(model,userRepository);
        return "adminAddGallery";
    }

    @PostMapping(value ="/admin/galleries")
    public String addUser(@ModelAttribute("gallery") Gallery gallery, Model model){
        if(galleryRepository.findByName(gallery.getName())!=null){

            model.addAttribute("message","Gallery with such name already exists");
            return "adminAddGalleryResult";
        }
        galleryRepository.save(gallery);
        model.addAttribute("message","Adding gallery Was succesfull");
        return "adminAddGalleryResult";
    }

    @GetMapping(value ="/admin/gallery")
    public String adminPhoto(Model model){
        adminService.addGallery(model);
        adminService.listOfGalleries(model,galleryRepository);
        return "adminAddPhoto";
    }
    @GetMapping(value ="/admin/gallery/{id}")
    public String adminAddPhoto(@PathVariable Long id, Model model){
        adminService.addGallery(model);
        adminService.listOfGalleries(model,galleryRepository);
        return "adminAddPhoto";
    }

    @PostMapping(value ="/admin/gallery")
    public String addPhotosToGallery(@ModelAttribute("gallery") Gallery gallery, Model model){
        adminService.addPhoto(model);
        adminService.listOfGalleries(model,galleryRepository);
        return "adminAddPhotoToGallery";
    }

//    @PostMapping(value ="/admin/gallery/photo")
//    public String addPhotosToGallery(@ModelAttribute("gallery") Gallery gallery, Model model){
//        if(galleryRepository.findByName(gallery.getName())!=null){
//
//            model.addAttribute("message","Gallery with such name already exists");
//            return "adminAddPhotoToGalleryResult";
//        }
//        galleryRepository.save(gallery);
//        model.addAttribute("message","Adding gallery Was succesfull");
//        return "adminAddPhotoToGalleryResult";
//    }
//    @DeleteMapping(value="admin/users")
//    public String deleteUser(@ModelAttribute("id") Long id, Model model){
//
//    return "adminAddUserSuccess";
//
//    }
}

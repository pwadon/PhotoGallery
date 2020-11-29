package project.photoGallery.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.User;
import project.photoGallery.repository.GalleryRepository;
import project.photoGallery.repository.UserRepository;
import project.photoGallery.service.AdminService;
import project.photoGallery.service.PhotoService;

@Controller
@AllArgsConstructor
@RequestMapping("/photogallery")
public class AdminController {

    private AdminService adminService;
    private UserRepository userRepository;
    private GalleryRepository galleryRepository;
    private PasswordEncoder passwordEncoder;
    private PhotoService photoService;

    @GetMapping(value ="/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping(value ="/admin/users")
    public String addUser(Model model){
        adminService.addUser(model);

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
        adminService.listOfUsers(model,userRepository);
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
        adminService.addGalleryToModel(model,galleryRepository,id);
        return "adminAddPhotoToGallery";
    }

    @PostMapping(value ="/admin/gallery/{id}")
    public String addPhotosToGallery(@RequestParam("file") MultipartFile file,@PathVariable Long id, Model model) {
        Gallery gallery = adminService.getGallery(galleryRepository, id);
        model.addAttribute("gallery", gallery);
        String str = "";
        try {
            if (file != null && file.getContentType().equals("image/jpeg")) {
                photoService.saveFile(file, gallery);
                str ="zdjęcie zostało dodane.";
            } else {
                str = "zły format pliku. akceptowalne są tylko pliki image/jpeg";
            }
            model.addAttribute("message", str);
            return "adminAddPhotoToGalleryResult";
        } catch (Exception e) {
            str = "Nie udało się wgrać pliku.";
            model.addAttribute("message", str);
            return "adminAddPhotoToGalleryResult";
        }
    }
}

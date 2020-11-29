package project.photoGallery.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.Photo;
import project.photoGallery.entity.User;
import project.photoGallery.repository.GalleryRepository;
import project.photoGallery.repository.UserRepository;
import java.util.List;



@Service
public class AdminService {

    public void addUser(Model model){
        model.addAttribute("user", new User());
    }

    public void addGallery(Model model){
        model.addAttribute("gallery", new Gallery());
    }
    public void addPhoto(Model model){
        model.addAttribute("photo",new Photo());
    }

    public void listOfUsers(Model model, UserRepository userRepository){
        List<User> userList = userRepository.findAllByRoles("USER");
        model.addAttribute("users",userList);
    }

    public void listOfGalleries(Model model, GalleryRepository galleryRepository){
        List<Gallery> galleries = galleryRepository.findAll();
        model.addAttribute("galleries",galleries);
    }

    public void addGalleryToModel(Model model, GalleryRepository galleryRepository, Long id){
        Gallery gallery = galleryRepository.getOne(id);
        model.addAttribute("gallery",gallery);
    }
    public Gallery getGallery(GalleryRepository galleryRepository, Long id){
        return galleryRepository.getOne(id);
    }
}

//    public void getListOfUsersToDelete(Model model, UserRepository userRepository){
//        List<User> userList = userRepository.findAllByRoles("USER");
//        model.addAttribute("Users",userList);
//        for (User user: userList){
//            System.out.println(user.getLogin());
//        }
//
//    }


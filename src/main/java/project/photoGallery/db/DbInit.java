package project.photoGallery.db;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.User;
import project.photoGallery.repository.GalleryRepository;
import project.photoGallery.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private GalleryRepository galleryRepository;
    private PasswordEncoder passwordEncoder;



    @Override
    public void run(String... args) {
        User admin = new User("admin",passwordEncoder.encode("admin"),"ADMIN");
        User piotrek = new User("piotrek",passwordEncoder.encode("piotrek"),"USER");
        User andrzej = new User("andrzej",passwordEncoder.encode("andrzej"),"USER");

        Gallery gallery = new Gallery("Galeria Piotrka 1",piotrek);
        Gallery galler2 = new Gallery("Galeria Piotrka 2",piotrek);
        List<User> users = Arrays.asList(admin,piotrek,andrzej);
        List<User> usersFromDatabase = userRepository.findAll();
        if(usersFromDatabase.size()  == 0){
            this.userRepository.saveAll(users);
            this.galleryRepository.save(gallery);
            this.galleryRepository.save(galler2);
        }

    }




}

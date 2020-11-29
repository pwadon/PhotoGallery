package project.photoGallery.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.photoGallery.entity.User;
import project.photoGallery.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        User admin = new User("admin",passwordEncoder.encode("adminadmin"),"ADMIN");
        User piotrek = new User("piotrek",passwordEncoder.encode("piotrek"),"USER");
        User andrzej = new User("andrzej",passwordEncoder.encode("andrzej"),"USER");

        List<User> users = Arrays.asList(admin,piotrek,andrzej);
        List<User> usersFromDatabase = userRepository.findAll();
        if(usersFromDatabase.size()  == 0) this.userRepository.saveAll(users);
    }




}

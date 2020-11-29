package project.photoGallery.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.Photo;
import project.photoGallery.repository.GalleryRepository;
import project.photoGallery.repository.PhotoRepository;
import project.photoGallery.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HomeService {

    PhotoRepository photoRepository;
    GalleryRepository galleryRepository;
    UserRepository userRepository;

    public void addPhotosAndNameToView(Model model) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, List<String>> galleryAndPhotos = new HashMap<>();
        List<Gallery> listOfGalleries = galleryRepository.findAllByUser(userRepository.findByLogin(userLogin));
        List<String> listOfPhotos;
        for (Gallery g : listOfGalleries) {
            listOfPhotos = photoRepository.getAllByGallery(g).stream().map(p -> Base64.getEncoder().encodeToString(p.getFile())).collect(Collectors.toList());
            if(listOfPhotos.size()>0) galleryAndPhotos.put(g.getName(),listOfPhotos);
        }

        model.addAttribute("galleryAndPhotos", galleryAndPhotos);
        model.addAttribute("name", userLogin);
    }
}

package project.photoGallery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.Photo;
import project.photoGallery.repository.PhotoRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    public Photo saveFile(MultipartFile file, Gallery gallery) throws IOException{
        String fileName = file.getOriginalFilename();
        try{
            Photo photo = new Photo(fileName,file.getContentType(),file.getBytes(),gallery);
            return photoRepository.save(photo);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Photo> getFile(Long id){
        return photoRepository.findById(id);
    }

    public List<Photo> getFiles(){
        return photoRepository.findAll();
    }


}

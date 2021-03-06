package project.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.User;

import java.util.List;


@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long> {

    Gallery findByName(String name);
    List<Gallery> findAllByUser(User user);
    @Override
    Gallery getOne(Long aLong);
}

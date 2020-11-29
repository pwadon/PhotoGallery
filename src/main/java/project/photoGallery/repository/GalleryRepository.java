package project.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.photoGallery.entity.Gallery;


@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long> {

    Gallery findByName(String name);

}

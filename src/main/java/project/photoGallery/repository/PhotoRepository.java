package project.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.photoGallery.entity.Gallery;
import project.photoGallery.entity.Photo;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {

    @Override
    Photo getOne(Long aLong);

    List<Photo> getAllByGallery(Gallery gallery);
}

package project.photoGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.photoGallery.entity.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);
//    List<User> findAllByRoles(String string);
}

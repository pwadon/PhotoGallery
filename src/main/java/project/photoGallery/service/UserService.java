package project.photoGallery.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import project.photoGallery.entity.User;
import project.photoGallery.repository.UserRepository;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;


@Service
@AllArgsConstructor
public class UserService  {


    private final UserRepository userRepository;

    public User loadUserByUserLogin(String login, String password, HttpSession sess) throws UsernameNotFoundException, LoginException {
        final User user = userRepository.findByLogin(login);

        if(user == null){
            throw new UsernameNotFoundException("User with login " + login + " cannot be found.");
        }else if (!BCrypt.checkpw(password,user.getPassword())){
            throw new LoginException("wrong password");
        }
        else sess.setAttribute("user",user);
        return user;
    }


}

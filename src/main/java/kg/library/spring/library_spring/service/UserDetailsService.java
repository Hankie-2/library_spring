package kg.library.spring.library_spring.service;

import kg.library.spring.library_spring.dao.UserRepository;
import kg.library.spring.library_spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not find user with that login");
        }
        return new kg.library.spring.library_spring.Security.UserDetails(user);
    }
}

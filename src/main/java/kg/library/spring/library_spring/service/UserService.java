package kg.library.spring.library_spring.service;

import kg.library.spring.library_spring.entity.Book;
import kg.library.spring.library_spring.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    public List<User> findAllByRoles(String role);

    public List<User> findALl();

    public List<User> findByNameAndAndRoles(String name,String role);

    public List<User> findBySurnameAndRoles(String surname,String role);


}

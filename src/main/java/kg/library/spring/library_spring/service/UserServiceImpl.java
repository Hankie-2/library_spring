package kg.library.spring.library_spring.service;

import kg.library.spring.library_spring.dao.BookRepository;
import kg.library.spring.library_spring.dao.UserRepository;
import kg.library.spring.library_spring.entity.Book;
import kg.library.spring.library_spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByLogin(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public List<User> findAllByRoles(String role) {
        List<User> readerList = userRepository.findAllByRoles(role);
        return readerList;
    }

    @Override
    public List<User> findALl() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByNameAndAndRoles(String name,String role){
        List<User> readerByName = userRepository.findByNameAndAndRoles(name,role);
        return readerByName;
    }

    @Override
    public List<User> findBySurnameAndRoles(String surname, String role) {
        List<User> readerBySurname = userRepository.findBySurnameAndRoles(surname,role);
        return readerBySurname;
    }



}

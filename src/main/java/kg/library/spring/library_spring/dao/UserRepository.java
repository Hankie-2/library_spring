package kg.library.spring.library_spring.dao;

import kg.library.spring.library_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String username);

    List<User> findAllByRoles(String role);

    List<User> findByNameAndAndRoles(String name,String role);

    List<User> findBySurnameAndRoles(String surname,String role);
}

package kg.library.spring.library_spring.dao;

import kg.library.spring.library_spring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {
}

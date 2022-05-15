package kg.library.spring.library_spring.service;

import kg.library.spring.library_spring.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    void deleteBookByTitle(String title);

    void insertBook(String title, Long authorId, int year, BigDecimal sellCost, BigDecimal rentCost, int amount);

    List<Book> getAll();

    Page<Book> findPaginated(int pageN,int pageSize,String sortField,String sortDirection);
}

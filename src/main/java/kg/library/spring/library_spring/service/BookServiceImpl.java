package kg.library.spring.library_spring.service;

import kg.library.spring.library_spring.dao.BookRepository;
import kg.library.spring.library_spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}

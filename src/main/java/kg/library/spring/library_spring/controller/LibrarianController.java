package kg.library.spring.library_spring.controller;

import kg.library.spring.library_spring.dao.BookRepository;
import kg.library.spring.library_spring.entity.Book;
import kg.library.spring.library_spring.entity.User;
import kg.library.spring.library_spring.service.BookService;
import kg.library.spring.library_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/readers")
    public String getAllReaders(Model model){
        List<User> users = userService.findALl();
        model.addAttribute("users",users);
        return  "librarian/librarian";
    }

    @GetMapping("/readers/{name}")
    public List<User> getReaderByName(@PathVariable String name){
        List<User> reader = userService.findBySurnameAndRoles(name,"ROLE_READER");
        return reader;
    }

//    @GetMapping("/books")
//    public List<Book> getAllBooks(){
//        List<Book> allBooks = librarianService.getAllBooks();
//        return allBooks;
//    }
}

package kg.library.spring.library_spring.controller;


import kg.library.spring.library_spring.entity.Book;
import kg.library.spring.library_spring.entity.User;
import kg.library.spring.library_spring.service.BookService;
import kg.library.spring.library_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/menu")
    public String menu(Model model){
        return getAllBooks(1,model,"title","asc");
    }


    @GetMapping("/books/{pageN}")
    public String getAllBooks(@PathVariable (value = "pageN") int pageN,Model model,
                              @RequestParam("sortField") String sortField,
                              @RequestParam("sortDir") String sortDir){

        int pageSize = 10;

        Page<Book> page = bookService.findPaginated(pageN,pageSize,sortField,sortDir);
        List<Book> books = page.getContent();

        model.addAttribute("currentPage",pageN);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("books",books);
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc") ? "desc" : "asc");
        return "librarian/show-all-books";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") Long author,
                          @RequestParam("year") int year,
                          @RequestParam("sellCost")BigDecimal sellCost,
                          @RequestParam("rentCost")BigDecimal rentCost,
                          @RequestParam("amount") int amount){
        bookService.insertBook(title,author,year,sellCost,rentCost,amount);
        return "librarian/librarian";
    }

//    @GetMapping("/showAllBooks")
//    public String getAll(Model model){
//        List<Book> books = bookService.getAll();
//        model.addAttribute("books",books);
//        return  "librarian/show-all-books";
//    }

    @GetMapping("/readers/{name}")
    public List<User> getReaderByName(@PathVariable String name){
        List<User> reader = userService.findBySurnameAndRoles(name,"ROLE_READER");
        return reader;
    }


}

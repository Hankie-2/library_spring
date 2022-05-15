package kg.library.spring.library_spring.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import kg.library.spring.library_spring.dao.UserRepository;
import kg.library.spring.library_spring.entity.User;
import kg.library.spring.library_spring.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private LibrarianController librarianController;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

//    @GetMapping("/librarian")
//    public String getLibrarianPage(Model model){
//        return librarianController.getAllBooks(1,model,"title","asc");
//    }

    @GetMapping("/reader")
    public String getReaderPage(){
        return "reader/reader";
    }

    @GetMapping("/admnin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/error")
    public String getErrorPage(Model model){
        model.addAttribute("error",  model.asMap().get("error"));
        return "error";
    }
}
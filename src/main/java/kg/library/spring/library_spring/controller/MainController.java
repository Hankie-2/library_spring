package kg.library.spring.library_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/librarian")
    public String getLibrarianPage(){
        return "librarian/librarian";
    }

    @GetMapping("/reader")
    public String getReaderPage(){
        return "reader/reader";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }


    @GetMapping("/error")
    public String getErrorPage(Model model){
        model.addAttribute("error",  model.asMap().get("error"));
        return "error";
    }
}

package pl.shop.Traning_Application.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {
    @GetMapping("/failed-login")
    public String faildeLogin(Authentication authentication, Principal principal) {
        return "failed-login";
    }

    @GetMapping("/")
    public String home(Authentication authentication, Principal principal) {
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Authentication authentication, Principal principal) {
        return "index";
    }
}

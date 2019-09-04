package pl.shop.H2OShop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Authentication authentication, Principal principal) {
        return "index";
    }
    @GetMapping("/failed-login")
    public String faildeLogin(Authentication authentication, Principal principal) {
        return "failed-login";
    }

}

package com.portal.Ecommerce;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String homePage(Model model, @AuthenticationPrincipal OAuth2User user){
        String name = user.getAttribute("given_name");
        model.addAttribute("name", name);
        return "home";
    }
}

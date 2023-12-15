package com.example.Messenger.Security.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageAccessController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }
}

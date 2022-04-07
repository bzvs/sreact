package ru.bzvs.sreact.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bzvs.sreact.dto.AuthenticationBean;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean authenticate() {
        return new AuthenticationBean();
    }
}

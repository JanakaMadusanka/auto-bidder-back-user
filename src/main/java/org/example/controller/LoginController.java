package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoginDto;
import org.example.service.LoginService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    final LoginService service;

    @PostMapping("/request")
    public void validateLogin(@RequestBody LoginDto loginDto){
        service.validateLogin(loginDto);
    }

}

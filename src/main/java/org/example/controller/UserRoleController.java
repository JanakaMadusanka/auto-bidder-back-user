package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user-role")
@RequiredArgsConstructor
public class UserRoleController {
    final UserRoleService service;
}

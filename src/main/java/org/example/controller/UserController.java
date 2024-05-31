package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserService service;
    @PostMapping("/register")
    public void registerUser(@RequestBody UserDto userDto){
        service.addUser(userDto);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        if(service.updateUser(userDto)){
            return "Updated";
        }
        return "User doesn't exist";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (service.deleteUser(id)) {
            return "Deleted";
        }
        return "User doesn't exist";
    }

    @GetMapping("/get/all")
    public List<UserDto> getAllUser(){
        return service.getAllUser();
    }

    @GetMapping("/search-by-id/{id}")
    public UserDto searchUserById(@PathVariable Long id){
        return service.searchUserById(id);
    }

    @GetMapping("/search-by-name/{firstName}")
    public UserDto searchUserByName(@PathVariable String firstName){
        return service.searchUserByName(firstName);
    }
}

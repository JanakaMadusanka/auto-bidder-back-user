package org.example.service;

import org.example.dto.LoginDto;
import org.example.dto.UserDto;

public interface LoginService {
    void insertLoginData(LoginDto loginDto);
    boolean validateLogin(LoginDto loginDto);
    boolean isExistUser(UserDto userDto);
}

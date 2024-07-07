package org.example.service;

import org.example.dto.LoginDto;
import org.example.dto.UserDto;
import org.example.entity.LoginEntity;

public interface LoginService {
    void insertLoginData(LoginDto loginDto);
    boolean validateLogin(LoginDto loginDto);
    boolean isExistUser(UserDto userDto);
    LoginEntity searchByEmail(String email);
}

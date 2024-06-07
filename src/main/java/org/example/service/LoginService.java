package org.example.service;

import org.example.dto.LoginDto;

public interface LoginService {
    void insertLoginData(LoginDto loginDto);

    boolean validateLogin(LoginDto loginDto);
}

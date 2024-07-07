package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoginDto;
import org.example.dto.UserDto;
import org.example.entity.LoginEntity;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    final LoginRepository repository;
    final ModelMapper mapper;
    @Override
    public void insertLoginData(LoginDto loginDto) {
        repository.save(mapper.map(loginDto, LoginEntity.class));
    }
    @Override
    public boolean validateLogin(LoginDto loginDto) {
        return repository.existsByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
    }
    @Override
    public boolean isExistUser(UserDto userDto) {
        return repository.existsByEmail(userDto.getEmail());
    }

    public LoginEntity searchByEmail(String email){
        return repository.searchByEmail(email);
    }
}

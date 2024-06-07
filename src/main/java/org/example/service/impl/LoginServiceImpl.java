package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoginDto;
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
}

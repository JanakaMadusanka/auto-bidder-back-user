package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entity.UserEntity;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.example.repository.UserRoleRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    final UserRoleRepository userRoleRepository;
    final RoleRepository roleRepository;
    final ModelMapper mapper;

    @Override
    public Long addUser(UserDto userDto) {
        UserEntity entity = mapper.map(userDto,UserEntity.class);
        UserEntity savedEntity = repository.save(entity);
        return (savedEntity.getId());
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        Long userId = userDto.getId();
        if (userId != null){
            UserEntity existingUser = repository.findById(userId).orElse(null);
            if(existingUser !=null){
                repository.save(mapper.map(userDto,UserEntity.class));
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> entityList = (List<UserEntity>) repository.findAll();
        List<UserDto> userList = new ArrayList<>();

        for(UserEntity entity : entityList){
            userList.add(mapper.map(entity,UserDto.class));
        }
        return userList;
    }

    @Override
    public UserDto searchUserById(Long id) {
        return mapper.map(repository.findById(id),UserDto.class);
    }
}

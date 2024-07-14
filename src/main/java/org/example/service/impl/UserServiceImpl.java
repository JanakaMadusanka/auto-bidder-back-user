package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.dto.UserRoleDto;
import org.example.entity.LoginEntity;
import org.example.entity.UserEntity;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.example.repository.UserRoleRepository;
import org.example.service.LoginService;
import org.example.service.UserRoleService;
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
    final LoginService loginService;
    final UserRoleService userRoleService;
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

    @Override
    public UserDto searchByEmail(String email) {

        //get user details and map to userDto
        LoginEntity loginEntity = loginService.searchByEmail(email);
        Long userId = loginEntity.getUserId();
        UserDto userDto = mapper.map(repository.findById(userId),UserDto.class);

        //get userRoleDto list of the user
        List<UserRoleDto> userRoleDtoList = userRoleService.searchByEmail(email);
        //converting the list to a set
        Set<Short> userRoleSet = new HashSet<>();
        for (UserRoleDto userRoleDto : userRoleDtoList) {
            userRoleSet.add(userRoleDto.getRoleId());
        }
        //set userRoleSet to userDto
        userDto.setUserRole(userRoleSet);
        return userDto;
    }

}

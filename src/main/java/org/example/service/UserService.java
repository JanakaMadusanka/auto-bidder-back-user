package org.example.service;

import org.example.dto.UserDto;
import org.example.dto.UserRoleDto;

import java.util.List;
import java.util.Set;

public interface UserService {
    Long addUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(Long id);
    List<UserDto> getAllUser();
    UserDto searchUserById(Long id);
    UserDto searchByEmail(String email);
}

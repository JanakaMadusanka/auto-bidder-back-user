package org.example.service;

import org.example.dto.UserDto;
import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(Long id);
    List<UserDto> getAllUser();
    UserDto searchUserById(Long id);
    UserDto searchUserByName(String Name);
}

package org.example.service;

import org.example.dto.UserDto;
import org.example.dto.UserRoleDto;
import org.example.entity.UserRoleEntity;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    void insertUserRoleData(Long userId, Set<Short> userRole);

    List<UserRoleDto> searchByUserId(Long userId);

    List<UserRoleDto> searchByEmail(String email);
}

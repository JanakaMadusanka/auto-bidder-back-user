package org.example.service;

import org.example.dto.UserRoleDto;
import java.util.List;
import java.util.Set;

public interface UserRoleService {
    void insertUserRoleData(Long userId, Set<Short> userRole);

    List<UserRoleDto> searchByUserId(Long userId);

    List<UserRoleDto> searchByEmail(String email);
}

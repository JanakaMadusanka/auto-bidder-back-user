package org.example.service;

import java.util.Set;

public interface UserRoleService {
    void insertUserRoleData(Long userId, Set<Short> userRole);
}

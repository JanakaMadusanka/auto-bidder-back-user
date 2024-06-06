package org.example.service;

import org.example.dto.RoleDto;
import java.util.List;

public interface RoleService {
    void addRole(RoleDto roleDto);
    boolean updateRole(RoleDto roleDto);

    boolean deleteRole(Short id);

    List<RoleDto> getAllRole();
    RoleDto searchRoleById(Short id);
}

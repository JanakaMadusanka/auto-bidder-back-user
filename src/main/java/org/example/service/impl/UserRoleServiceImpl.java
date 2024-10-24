package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserRoleDto;
import org.example.entity.UserRoleEntity;
import org.example.repository.RoleRepository;
import org.example.repository.UserRoleRepository;
import org.example.service.LoginService;
import org.example.service.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {
    final UserRoleRepository repository;
    final RoleRepository roleRepository;
    final LoginService loginService;
    final ModelMapper mapper;
    @Override
    public void insertUserRoleData(Long userId, Set<Short> userRole) {
        Set<UserRoleEntity> userRoles = new HashSet<>();
        for (Short roleId : userRole) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setRoleId(roleId);
            userRoleEntity.setUserId(userId);
            userRoles.add(userRoleEntity);
        }
        repository.saveAll(userRoles); // Save userRoles
    }
    @Override
    public List<UserRoleDto> searchByUserId(Long userId) {
        List<UserRoleEntity> userRoles = repository.findByUserId(userId);
        return userRoles.stream()
                .map(userRole -> mapper.map(userRole, UserRoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDto> searchByEmail(String email) {
        Long userId = loginService.searchByEmail(email).getUserId();
        return searchByUserId(userId);
    }
}

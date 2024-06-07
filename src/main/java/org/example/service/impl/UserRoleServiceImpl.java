package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserRoleEntity;
import org.example.repository.RoleRepository;
import org.example.repository.UserRoleRepository;
import org.example.service.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {
    final UserRoleRepository repository;
    final RoleRepository roleRepository;
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


//    public void insertUserRoleData(Long userId, Set<Short> userRole) {
//        Set<UserRoleEntity> userRoles = new HashSet<>();
//        for (Short roleId : userRole) {
//            Optional<RoleEntity> roleEntityOptional = roleRepository.findById(roleId);
//            if (roleEntityOptional.isPresent()) {
//                RoleEntity roleEntity = roleEntityOptional.get(); // Unwrap the Optional
//                UserRoleEntity userRoleEntity = new UserRoleEntity();
//                userRoleEntity.setRoleId(roleEntity.getId());
//                userRoleEntity.setUserId(userId);
//                userRoles.add(userRoleEntity);
//            }
//        }
//        repository.saveAll(userRoles); // Save user roles
//    }
}

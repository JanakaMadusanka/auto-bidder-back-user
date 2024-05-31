package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.RoleDto;
import org.example.entity.RoleEntity;
import org.example.repository.RoleRepository;
import org.example.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository repository;
    final ModelMapper mapper;

    @Override
    public void addRole(RoleDto roleDto) {
        RoleEntity entity = mapper.map(roleDto, RoleEntity.class);
        repository.save(entity);
    }
    @Override
    public boolean updateRole(RoleDto roleDto) {
        Long roleId = roleDto.getId();
        if (roleId != null){
            RoleEntity existingUser = repository.findById(roleId).orElse(null);
            if(existingUser !=null){
                repository.save(mapper.map(roleDto,RoleEntity.class));
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteRole(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<RoleDto> getAllRole() {
        List<RoleEntity> entityList = (List<RoleEntity>) repository.findAll();
        List<RoleDto> userList = new ArrayList<>();

        for(RoleEntity entity : entityList){
            userList.add(mapper.map(entity,RoleDto.class));
        }
        return userList;
    }

    @Override
    public RoleDto searchRoleById(Long id) {
        return mapper.map(repository.findById(Long.valueOf(id)),RoleDto.class);
    }
}

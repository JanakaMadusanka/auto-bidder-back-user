package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.RoleDto;
import org.example.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    final RoleService service;
    @PostMapping("/register")
    public void registerUser(@RequestBody RoleDto roleDto){
        service.addRole(roleDto);
    }

    @PutMapping("/update/{id}")
    public String updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto){
        roleDto.setId(id);
        if(service.updateRole(roleDto)){
            return "Updated";
        }
        return "Role doesn't exist";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        if (service.deleteRole(id)) {
            return "Deleted";
        }
        return "Role doesn't exist";
    }

    @GetMapping("/get/all")
    public List<RoleDto> getAllRole(){
        return service.getAllRole();
    }

    @GetMapping("/search-by-id/{id}")
    public RoleDto searchUserById(@PathVariable Long id){
        return service.searchRoleById(id);
    }
}

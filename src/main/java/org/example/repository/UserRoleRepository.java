package org.example.repository;

import org.example.entity.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Long> {
    List<UserRoleEntity> findByUserId(Long userId);
}

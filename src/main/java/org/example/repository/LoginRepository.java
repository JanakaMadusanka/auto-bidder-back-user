package org.example.repository;

import org.example.entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginEntity,Long> {
    Boolean existsByEmailAndPassword(String email, String password);
}

package com.microservice.UserService.repository;

import com.microservice.UserService.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Integer> {
}

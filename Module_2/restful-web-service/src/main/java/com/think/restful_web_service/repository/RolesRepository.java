package com.think.restful_web_service.repository;

import com.think.restful_web_service.dao.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository  extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
}

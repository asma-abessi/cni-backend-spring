package com.cniback.cniback.dao;



import java.util.Optional;

import com.cniback.cniback.modele.Role;
import com.cniback.cniback.modele.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
 
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
package ld01.demo3springsecurity.repository;

import ld01.demo3springsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT u FROM Role u WHERE u.name = :name")
    public Role getUserByName(@Param("name") String name);
    Optional<Role> findByName(String name);
}

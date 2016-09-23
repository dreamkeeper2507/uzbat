package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
}

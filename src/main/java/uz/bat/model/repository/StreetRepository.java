package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Street;


@Repository
public interface StreetRepository extends JpaRepository<Street, Long>
{
}

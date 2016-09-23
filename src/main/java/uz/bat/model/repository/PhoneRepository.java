package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Phone;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>
{
}

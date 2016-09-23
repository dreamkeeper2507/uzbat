package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long>
{
}

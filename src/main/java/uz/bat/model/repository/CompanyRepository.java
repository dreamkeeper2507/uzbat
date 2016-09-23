package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>
{
}

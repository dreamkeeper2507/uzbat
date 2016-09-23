package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Brand;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>
{
}

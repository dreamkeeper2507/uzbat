package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.ProductUnit;


@Repository
public interface ProductUnitRepository extends JpaRepository<ProductUnit, Long>
{
}

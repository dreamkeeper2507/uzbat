package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>
{
}

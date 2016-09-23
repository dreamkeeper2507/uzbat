package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.StoreType;


@Repository
public interface StoreTypeRepository extends JpaRepository<StoreType, Long>
{
}

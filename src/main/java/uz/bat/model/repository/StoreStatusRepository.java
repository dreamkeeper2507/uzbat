package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.StoreStatus;


@Repository
public interface StoreStatusRepository extends JpaRepository<StoreStatus, Long>
{
}

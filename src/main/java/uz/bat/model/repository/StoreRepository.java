package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>
{
}

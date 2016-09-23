package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Region;


@Repository
public interface RegionRepository extends JpaRepository<Region, Long>
{
}

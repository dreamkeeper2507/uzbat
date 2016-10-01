package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Region;

import java.util.List;


@Repository
public interface RegionRepository extends JpaRepository<Region, Long>
{  @Query("select r from Region r where r.state.id=:stateId")
    List<Region> findByCategoryId(@Param("stateId") Long id);
}

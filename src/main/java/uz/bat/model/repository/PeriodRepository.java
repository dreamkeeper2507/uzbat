package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Period;


@Repository
public interface PeriodRepository extends JpaRepository<Period, Long>
{
}

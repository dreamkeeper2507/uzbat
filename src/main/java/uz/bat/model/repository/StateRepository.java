package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.State;


@Repository
public interface StateRepository extends JpaRepository<State, Long>
{
}

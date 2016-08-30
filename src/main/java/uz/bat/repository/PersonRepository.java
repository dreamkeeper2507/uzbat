package uz.bat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bat.model.entity.Person;


/**
 * Created by Khusan on 28.08.2016.
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
}

package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}

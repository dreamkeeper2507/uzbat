package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.CategoryInfo;


@Repository
public interface CategoryInfoRepository extends JpaRepository<CategoryInfo, Long>
{
}

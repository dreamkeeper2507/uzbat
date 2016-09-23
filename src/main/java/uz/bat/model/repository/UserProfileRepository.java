package uz.bat.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.bat.model.entity.UserProfile;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>
{
}

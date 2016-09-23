package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.UserProfile;
import uz.bat.model.repository.UserProfileRepository;

import java.util.List;

@Service
public class UserProfileService
{

    public List<UserProfile> all()
    {
        return userProfileRepository.findAll();
    }

    public UserProfile findOne(Long id)
    {
        return userProfileRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        userProfileRepository.delete(id);
    }

    @Transactional
    public void create(UserProfile userProfile)
    {
        userProfileRepository.save(userProfile);
    }

    @Transactional
    public void edit(UserProfile userProfile)
    {
        userProfileRepository.save(userProfile);
    }

    public List<UserProfile> criteria(Page page)
    {
        return userProfileRepository.findAll(page);
    }

    @Autowired
    UserProfileRepository userProfileRepository;
}

package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.User;
import uz.bat.model.repository.UserRepository;

import java.util.List;

@Service
public class UserService
{

    public List<User> all()
    {
        return userRepository.findAll();
    }

    public User findOne(Long id)
    {
        return userRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        userRepository.delete(id);
    }

    @Transactional
    public void create(User user)
    {
        userRepository.save(user);
    }

    @Transactional
    public void edit(User user)
    {
        userRepository.save(user);
    }

    public List<User> criteria(Page page)
    {
        return userRepository.findAll(page);
    }

    @Autowired
    UserRepository userRepository;
}

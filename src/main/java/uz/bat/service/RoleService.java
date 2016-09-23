package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Role;
import uz.bat.model.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService
{

    public List<Role> all()
    {
        return roleRepository.findAll();
    }

    public Role findOne(Long id)
    {
        return roleRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        roleRepository.delete(id);
    }

    @Transactional
    public void create(Role role)
    {
        roleRepository.save(role);
    }

    @Transactional
    public void edit(Role role)
    {
        roleRepository.save(role);
    }

    public List<Role> criteria(Page page)
    {
        return roleRepository.findAll(page);
    }

    @Autowired
    RoleRepository roleRepository;
}

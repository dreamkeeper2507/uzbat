package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Phone;
import uz.bat.model.repository.PhoneRepository;

import java.util.List;

@Service
public class PhoneService
{

    public List<Phone> all()
    {
        return phoneRepository.findAll();
    }

    public Phone findOne(Long id)
    {
        return phoneRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        phoneRepository.delete(id);
    }

    @Transactional
    public void create(Phone phone)
    {
        phoneRepository.save(phone);
    }

    @Transactional
    public void edit(Phone phone)
    {
        phoneRepository.save(phone);
    }

    public List<Phone> criteria(Page page)
    {
        return phoneRepository.findAll(page);
    }

    @Autowired
    PhoneRepository phoneRepository;
}

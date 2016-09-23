package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Person;
import uz.bat.model.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService
{

    public List<Person> all()
    {
        return personRepository.findAll();
    }

    public Person findOne(Long id)
    {
        return personRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        personRepository.delete(id);
    }

    @Transactional
    public void create(Person person)
    {
        personRepository.save(person);
    }

    @Transactional
    public void edit(Person person)
    {
        personRepository.save(person);
    }

    public List<Person> criteria(Page page)
    {
        return personRepository.findAll(page);
    }

    @Autowired
    PersonRepository personRepository;
}

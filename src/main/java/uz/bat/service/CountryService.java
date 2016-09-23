package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Country;
import uz.bat.model.repository.CountryRepository;

import java.util.List;

@Service
public class CountryService
{

    public List<Country> all()
    {
        return countryRepository.findAll();
    }

    public Country findOne(Long id)
    {
        return countryRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        countryRepository.delete(id);
    }

    @Transactional
    public void create(Country country)
    {
        countryRepository.save(country);
    }

    @Transactional
    public void edit(Country country)
    {
        countryRepository.save(country);
    }

    public List<Country> criteria(Page page)
    {
        return countryRepository.findAll(page);
    }

    @Autowired
    CountryRepository countryRepository;
}

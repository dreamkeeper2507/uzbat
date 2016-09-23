package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Company;
import uz.bat.model.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService
{

    public List<Company> all()
    {
        return companyRepository.findAll();
    }

    public Company findOne(Long id)
    {
        return companyRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        companyRepository.delete(id);
    }

    @Transactional
    public void create(Company company)
    {
        companyRepository.save(company);
    }

    @Transactional
    public void edit(Company company)
    {
        companyRepository.save(company);
    }

    public List<Company> criteria(Page page)
    {
        return companyRepository.findAll(page);
    }

    @Autowired
    CompanyRepository companyRepository;
}

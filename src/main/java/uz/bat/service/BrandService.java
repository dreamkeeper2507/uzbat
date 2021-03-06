package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Brand;
import uz.bat.model.entity.Company;
import uz.bat.model.repository.BrandRepository;
import uz.bat.model.repository.CompanyRepository;

import java.util.List;

@Service
public class BrandService {

    public List<Brand> all() {
        return brandRepository.findAll();
    }

    public Brand findOne(Long id) {
        return brandRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id) {
        brandRepository.delete(id);
    }

    @Transactional
    public void create(Brand brand) {
        brandRepository.save(brand);
    }

    @Transactional
    public void edit(Brand brand) {
        brandRepository.save(brand);
    }

    public List<Brand> criteria(Page page) {
        return brandRepository.findAll(page);
    }

    public List<Company> allCompanys() {
        return companyRepository.findAll();
    }

    public Company findOneCompany(Long companyId) {
        return companyRepository.findOne(companyId);
    }

    @Autowired
    BrandRepository brandRepository;
    @Autowired
    CompanyRepository companyRepository;

}

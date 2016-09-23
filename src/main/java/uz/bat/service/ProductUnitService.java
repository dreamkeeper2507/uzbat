package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.ProductUnit;
import uz.bat.model.repository.ProductUnitRepository;

import java.util.List;

@Service
public class ProductUnitService
{

    public List<ProductUnit> all()
    {
        return productUnitRepository.findAll();
    }

    public ProductUnit findOne(Long id)
    {
        return productUnitRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        productUnitRepository.delete(id);
    }

    @Transactional
    public void create(ProductUnit productUnit)
    {
        productUnitRepository.save(productUnit);
    }

    @Transactional
    public void edit(ProductUnit productUnit)
    {
        productUnitRepository.save(productUnit);
    }

    public List<ProductUnit> criteria(Page page)
    {
        return productUnitRepository.findAll(page);
    }

    @Autowired
    ProductUnitRepository productUnitRepository;
}

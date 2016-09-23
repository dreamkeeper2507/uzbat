package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Supplier;
import uz.bat.model.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService
{

    public List<Supplier> all()
    {
        return supplierRepository.findAll();
    }

    public Supplier findOne(Long id)
    {
        return supplierRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        supplierRepository.delete(id);
    }

    @Transactional
    public void create(Supplier supplier)
    {
        supplierRepository.save(supplier);
    }

    @Transactional
    public void edit(Supplier supplier)
    {
        supplierRepository.save(supplier);
    }

    public List<Supplier> criteria(Page page)
    {
        return supplierRepository.findAll(page);
    }

    @Autowired
    SupplierRepository supplierRepository;
}

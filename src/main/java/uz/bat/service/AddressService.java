package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Address;
import uz.bat.model.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService
{

    public List<Address> all()
    {
        return addressRepository.findAll();
    }

    public Address findOne(Long id)
    {
        return addressRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        addressRepository.delete(id);
    }

    @Transactional
    public void create(Address address)
    {
        addressRepository.save(address);
    }

    @Transactional
    public void edit(Address address)
    {
        addressRepository.save(address);
    }

    public List<Address> criteria(Page page)
    {
        return addressRepository.findAll(page);
    }

    @Autowired
    AddressRepository addressRepository;
}

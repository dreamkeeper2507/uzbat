package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Address;
import uz.bat.model.entity.Person;
import uz.bat.model.entity.Store;
import uz.bat.model.entity.StoreType;
import uz.bat.model.repository.AddressRepository;
import uz.bat.model.repository.PersonRepository;
import uz.bat.model.repository.StoreRepository;
import uz.bat.model.repository.StoreTypeRepository;

import java.util.List;

@Service
public class StoreService
{

    public List<Store> all()
    {
        return storeRepository.findAll();
    }

    public Store findOne(Long id)
    {
        return storeRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        storeRepository.delete(id);
    }

    @Transactional
    public void create(Store store)
    {
        storeRepository.save(store);
    }

    @Transactional
    public void edit(Store store)
    {
        storeRepository.save(store);
    }

    public List<Store> criteria(Page page)
    {
        return storeRepository.findAll(page);
    }


    public List<Person> allPersons()
    {
        return personRepository.findAll();
    }

    public List<StoreType> allStoreTypes()
    {
        return storeTypeRepository.findAll();

    }

    public List<Address> allAddress()
    {
        return addressRepository.findAll();

    }

    public Address findAddressById(Long addressId)
    {
        return addressRepository.findOne(addressId);
    }

    public Person findPersonById(Long personId)
    {
        return personRepository.findOne(personId);
    }

    public StoreType findStoreTypeById(Long storeTypeId)
    {
        return storeTypeRepository.findOne(storeTypeId);
    }

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    StoreTypeRepository storeTypeRepository;
    @Autowired
    AddressRepository addressRepository;


}

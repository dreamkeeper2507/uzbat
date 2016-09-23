package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Store;
import uz.bat.model.repository.StoreRepository;

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

    @Autowired
    StoreRepository storeRepository;
}

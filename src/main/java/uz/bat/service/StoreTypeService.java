package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.StoreType;
import uz.bat.model.repository.StoreTypeRepository;

import java.util.List;

@Service
public class StoreTypeService
{

    public List<StoreType> all()
    {
        return storeTypeRepository.findAll();
    }

    public StoreType findOne(Long id)
    {
        return storeTypeRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        storeTypeRepository.delete(id);
    }

    @Transactional
    public void create(StoreType storeType)
    {
        storeTypeRepository.save(storeType);
    }

    @Transactional
    public void edit(StoreType storeType)
    {
        storeTypeRepository.save(storeType);
    }

    public List<StoreType> criteria(Page page)
    {
        return storeTypeRepository.findAll(page);
    }

    @Autowired
    StoreTypeRepository storeTypeRepository;
}

package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.StoreStatus;
import uz.bat.model.repository.StoreStatusRepository;

import java.util.List;

@Service
public class StoreStatusService
{

    public List<StoreStatus> all()
    {
        return storeStatesRepository.findAll();
    }

    public StoreStatus findOne(Long id)
    {
        return storeStatesRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        storeStatesRepository.delete(id);
    }

    @Transactional
    public void create(StoreStatus storeStates)
    {
        storeStatesRepository.save(storeStates);
    }

    @Transactional
    public void edit(StoreStatus storeStates)
    {
        storeStatesRepository.save(storeStates);
    }

    public List<StoreStatus> criteria(Page page)
    {
        return storeStatesRepository.findAll(page);
    }

    @Autowired
    StoreStatusRepository storeStatesRepository;
}

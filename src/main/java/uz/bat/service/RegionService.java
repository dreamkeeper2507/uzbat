package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Region;
import uz.bat.model.entity.State;
import uz.bat.model.repository.RegionRepository;
import uz.bat.model.repository.StateRepository;

import java.util.List;

@Service
public class RegionService
{

    public List<Region> all()
    {
        return regionRepository.findAll();
    }

    public Region findOne(Long id)
    {
        return regionRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        regionRepository.delete(id);
    }

    @Transactional
    public void create(Region region)
    {
        regionRepository.save(region);
    }

    @Transactional
    public void edit(Region region)
    {
        regionRepository.save(region);
    }

    public List<Region> criteria(Page page)
    {
        return regionRepository.findAll(page);
    }

    public List<State> allStates()
    {
        return stateRepository.findAll();
    }

    public State findOneState(Long stateId)
    {
      return   stateRepository.findOne(stateId);
    }

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    StateRepository stateRepository;


}

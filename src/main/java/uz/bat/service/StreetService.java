package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Region;
import uz.bat.model.entity.Street;
import uz.bat.model.repository.RegionRepository;
import uz.bat.model.repository.StreetRepository;

import java.util.List;

@Service
public class StreetService
{

    public List<Street> all()
    {
        return streetRepository.findAll();
    }

    public Street findOne(Long id)
    {
        return streetRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        streetRepository.delete(id);
    }

    @Transactional
    public void create(Street street)
    {
        streetRepository.save(street);
    }

    @Transactional
    public void edit(Street street)
    {
        streetRepository.save(street);
    }

    public List<Street> criteria(Page page)
    {
        return streetRepository.findAll(page);
    }


    public List<Region> allRegions()
    {
        return regionRepository.findAll();
    }

    public Region findOneRegion(Long regionId)
    {
        return regionRepository.findOne(regionId);
    }

    @Autowired
    StreetRepository streetRepository;
    @Autowired
    RegionRepository regionRepository;

}

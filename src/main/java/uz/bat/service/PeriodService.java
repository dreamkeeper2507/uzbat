package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Period;
import uz.bat.model.repository.PeriodRepository;

import java.util.List;

@Service
public class PeriodService
{

    public List<Period> all()
    {
        return periodRepository.findAll();
    }

    public Period findOne(Long id)
    {
        return periodRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        periodRepository.delete(id);
    }

    @Transactional
    public void create(Period period)
    {
        periodRepository.save(period);
    }

    @Transactional
    public void edit(Period period)
    {
        periodRepository.save(period);
    }

    public List<Period> criteria(Page page)
    {
        return periodRepository.findAll(page);
    }

    @Autowired
    PeriodRepository periodRepository;
}

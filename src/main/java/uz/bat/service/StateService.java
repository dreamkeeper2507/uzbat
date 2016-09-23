package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.State;
import uz.bat.model.repository.StateRepository;

import java.util.List;

@Service
public class StateService
{

    public List<State> all()
    {
        return stateRepository.findAll();
    }

    public State findOne(Long id)
    {
        return stateRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        stateRepository.delete(id);
    }

    @Transactional
    public void create(State state)
    {
        stateRepository.save(state);
    }

    @Transactional
    public void edit(State state)
    {
        stateRepository.save(state);
    }

    public List<State> criteria(Page page)
    {
        return stateRepository.findAll(page);
    }

    @Autowired
    StateRepository stateRepository;
}

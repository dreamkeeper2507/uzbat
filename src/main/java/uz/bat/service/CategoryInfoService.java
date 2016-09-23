package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.CategoryInfo;
import uz.bat.model.repository.CategoryInfoRepository;

import java.util.List;

@Service
public class CategoryInfoService
{

    public List<CategoryInfo> all()
    {
        return categoryInfoRepository.findAll();
    }

    public CategoryInfo findOne(Long id)
    {
        return categoryInfoRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        categoryInfoRepository.delete(id);
    }

    @Transactional
    public void create(CategoryInfo category)
    {
        categoryInfoRepository.save(category);
    }

    @Transactional
    public void edit(CategoryInfo category)
    {
        categoryInfoRepository.save(category);
    }

    public List<CategoryInfo> criteria(Page page)
    {
        return categoryInfoRepository.findAll(page);
    }

    @Autowired
    CategoryInfoRepository categoryInfoRepository;
}

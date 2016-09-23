package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Category;
import uz.bat.model.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService
{

    public List<Category> all()
    {
        return categoryRepository.findAll();
    }

    public Category findOne(Long id)
    {
        return categoryRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        categoryRepository.delete(id);
    }

    @Transactional
    public void create(Category category)
    {
        categoryRepository.save(category);
    }

    @Transactional
    public void edit(Category category)
    {
        categoryRepository.save(category);
    }

    public List<Category> criteria(Page page)
    {
        return categoryRepository.findAll(page);
    }

    @Autowired
    CategoryRepository categoryRepository;
}

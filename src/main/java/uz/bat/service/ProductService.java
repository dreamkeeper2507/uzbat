package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.Product;
import uz.bat.model.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService
{

    public List<Product> all()
    {
        return productRepository.findAll();
    }

    public Product findOne(Long id)
    {
        return productRepository.findOne(id);
    }

    @Transactional
    public void remove(Long id)
    {
        productRepository.delete(id);
    }

    @Transactional
    public void create(Product product)
    {
        productRepository.save(product);
    }

    @Transactional
    public void edit(Product product)
    {
        productRepository.save(product);
    }

    public List<Product> criteria(Page page)
    {
        return productRepository.findAll(page);
    }

    @Autowired
    ProductRepository productRepository;
}

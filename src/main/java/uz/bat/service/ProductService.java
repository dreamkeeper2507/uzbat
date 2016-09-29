package uz.bat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bat.model.entity.*;
import uz.bat.model.repository.*;

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
    public  List<Product> productsByCategory(Long id) {
        return productRepository.getProductsByCategoryId(id);
    }

    public List<ProductUnit> allPproductunit()
    {
        return productUnitRepository.findAll();
    }

    public List<Supplier> allSupplier()
    {
        return supplierRepository.findAll();
    }

    public List<Category> allCategory()
    {
        return categoryRepository.findAll();
    }

    public List<Brand> allBrand()
    {
        return brandRepository.findAll();
    }

    public Brand findBrandById(Long brandId)
    {return brandRepository.findOne(brandId);
    }

    public Category findCategoryById(Long categoryId)
    {
        return categoryRepository.findOne(categoryId);
    }

    public Supplier findSupplierById(Long supplierId)
    {
        return supplierRepository.findOne(supplierId);
    }

    public ProductUnit findProductunitById(Long productunitId)
    {
        return productUnitRepository.findOne(productunitId);
    }

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductUnitRepository productUnitRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BrandRepository brandRepository;



}

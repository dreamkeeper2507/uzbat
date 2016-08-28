package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the category database table.
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CATEGORY_ID_GENERATOR", sequenceName = "CATEGORY_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_GENERATOR")
    private Long id;

    private String categorydescription;

    private String categoryName;

    // bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name = "parentCategoryId")
    private Category category;

    // bi-directional many-to-one association to Category
    @OneToMany(mappedBy = "category")
    private List<Category> categories;

    // bi-directional many-to-many association to CategoryInfo
    @ManyToMany
    @JoinTable(name = "category_categoryinfo", joinColumns = {@JoinColumn(name = "category_id")}, inverseJoinColumns = {@JoinColumn(name = "categoryinfo_id")})
    private List<CategoryInfo> categoryinfos;

    // bi-directional many-to-one association to Product
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category()
    {
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCategorydescription()
    {
        return this.categorydescription;
    }

    public void setCategorydescription(String categorydescription)
    {
        this.categorydescription = categorydescription;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public List<Category> getCategories()
    {
        return this.categories;
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

    public Category addCategory(Category category)
    {
        getCategories().add(category);
        category.setCategory(this);

        return category;
    }

    public Category removeCategory(Category category)
    {
        getCategories().remove(category);
        category.setCategory(null);

        return category;
    }

    public List<CategoryInfo> getCategoryinfos()
    {
        return this.categoryinfos;
    }

    public void setCategoryinfos(List<CategoryInfo> categoryinfos)
    {
        this.categoryinfos = categoryinfos;
    }

    public List<Product> getProducts()
    {
        return this.products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    public Product addProduct(Product product)
    {
        getProducts().add(product);
        product.setCategory(this);

        return product;
    }

    public Product removeProduct(Product product)
    {
        getProducts().remove(product);
        product.setCategory(null);

        return product;
    }

}
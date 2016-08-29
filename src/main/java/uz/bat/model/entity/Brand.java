package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the brand database table.
 */
@Entity
@NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b")
public class Brand implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "BRAND_ID_GENERATOR", sequenceName = "BRAND_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_ID_GENERATOR")
    private Long id;

    private String brandName;

    private String description;

    // bi-directional many-to-one association to Company
    @ManyToOne
    @JoinColumn(name = "company")
    private Company companyBean;

    // bi-directional many-to-one association to Product
    @OneToMany(mappedBy = "brandBean")
    private List<Product> products;

    public Brand()
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

    public String getBrandName()
    {
        return this.brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Company getCompanyBean()
    {
        return this.companyBean;
    }

    public void setCompanyBean(Company companyBean)
    {
        this.companyBean = companyBean;
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
        product.setBrandBean(this);

        return product;
    }

    public Product removeProduct(Product product)
    {
        getProducts().remove(product);
        product.setBrandBean(null);

        return product;
    }

}
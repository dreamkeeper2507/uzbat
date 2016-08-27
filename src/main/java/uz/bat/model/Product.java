package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the product database table.
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PRODUCT_ID_GENERATOR", sequenceName = "PRODUCT_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID_GENERATOR")
    private Long id;

    private double maxPrice;

    private double minPrice;

    private String productCode;

    private String productName;

    // bi-directional many-to-one association to Supplier
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    // bi-directional many-to-one association to ProductUnit
    @ManyToOne
    @JoinColumn(name = "productUnit")
    private ProductUnit productunit;

    // bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name = "categoty")
    private Category category;

    // bi-directional many-to-one association to Brand
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brandBean;

    public Product()
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

    public double getMaxPrice()
    {
        return this.maxPrice;
    }

    public void setMaxPrice(double maxPrice)
    {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice()
    {
        return this.minPrice;
    }

    public void setMinPrice(double minPrice)
    {
        this.minPrice = minPrice;
    }

    public String getProductCode()
    {
        return this.productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Supplier getSupplier()
    {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }

    public ProductUnit getProductunit()
    {
        return this.productunit;
    }

    public void setProductunit(ProductUnit productunit)
    {
        this.productunit = productunit;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Brand getBrandBean()
    {
        return this.brandBean;
    }

    public void setBrandBean(Brand brandBean)
    {
        this.brandBean = brandBean;
    }

}
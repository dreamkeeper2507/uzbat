package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the productunits database table.
 */
@Entity
@Table(name = "productunits")
@NamedQuery(name = "ProductUnit.findAll", query = "SELECT p FROM ProductUnit p")
public class ProductUnit implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PRODUCTUNITS_ID_GENERATOR", sequenceName = "PRODUCTUNITS_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTUNITS_ID_GENERATOR")
    private Long id;

    private String unitName;

    // bi-directional many-to-one association to Product
    @OneToMany(mappedBy = "productunit")
    private List<Product> products;

    public ProductUnit()
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

    public String getUnitName()
    {
        return this.unitName;
    }

    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
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
        product.setProductunit(this);

        return product;
    }

    public Product removeProduct(Product product)
    {
        getProducts().remove(product);
        product.setProductunit(null);

        return product;
    }

}
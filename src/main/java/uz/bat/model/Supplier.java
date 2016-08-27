package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the supplier database table.
 */
@Entity
@NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
public class Supplier implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SUPPLIER_ID_GENERATOR", sequenceName = "SUPPLIER_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_ID_GENERATOR")
    private Long id;

    private String name;

    // bi-directional many-to-one association to Product
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    // bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "contactPerson")
    private Person person;

    public Supplier()
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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
        product.setSupplier(this);

        return product;
    }

    public Product removeProduct(Product product)
    {
        getProducts().remove(product);
        product.setSupplier(null);

        return product;
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

}
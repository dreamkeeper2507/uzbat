package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the store database table.
 */
@Entity
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STORE_ID_GENERATOR", sequenceName = "STORE_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_ID_GENERATOR")
    private Long id;

    private String location;

    private String storeName;

    // bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "owner")
    private Person person;

    // bi-directional many-to-one association to StoreType
    @ManyToOne
    @JoinColumn(name = "type")
    private StoreType storetype;

    // bi-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name = "address")
    private Address addressBean;

    public Store()
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

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getStoreName()
    {
        return this.storeName;
    }

    public void setStoreName(String storeName)
    {
        this.storeName = storeName;
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public StoreType getStoretype()
    {
        return this.storetype;
    }

    public void setStoretype(StoreType storetype)
    {
        this.storetype = storetype;
    }

    public Address getAddressBean()
    {
        return this.addressBean;
    }

    public void setAddressBean(Address addressBean)
    {
        this.addressBean = addressBean;
    }

}
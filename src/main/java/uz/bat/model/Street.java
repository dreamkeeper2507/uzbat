package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the street database table.
 */
@Entity
@NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s")
public class Street implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STREET_ID_GENERATOR", sequenceName = "STREET_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STREET_ID_GENERATOR")
    private Long id;

    private String name;

    //bi-directional many-to-one association to Address
    @OneToMany(mappedBy = "street")
    private List<Address> addresses;

    //bi-directional many-to-one association to Region
    @ManyToOne
    private Region region;

    public Street()
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

    public List<Address> getAddresses()
    {
        return this.addresses;
    }

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }

    public Address addAddress(Address address)
    {
        getAddresses().add(address);
        address.setStreet(this);

        return address;
    }

    public Address removeAddress(Address address)
    {
        getAddresses().remove(address);
        address.setStreet(null);

        return address;
    }

    public Region getRegion()
    {
        return this.region;
    }

    public void setRegion(Region region)
    {
        this.region = region;
    }

}
package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 */
@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address extends AbstractUzBatEntity
{
    private String address;

    @ManyToOne
    private Street street;

    public Address()
    {
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Street getStreet()
    {
        return this.street;
    }

    public void setStreet(Street street)
    {
        this.street = street;
    }

}
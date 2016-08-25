package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the region database table.
 */
@Entity
@NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
public class Region extends AbstractUzBatEntity
{
    private String code;

    private String name;

    //bi-directional many-to-one association to State
    @ManyToOne
    private State state;

    //bi-directional many-to-one association to Street
    @OneToMany(mappedBy = "region")
    private List<Street> streets;

    public Region()
    {
    }


    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public State getState()
    {
        return this.state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public List<Street> getStreets()
    {
        return this.streets;
    }

    public void setStreets(List<Street> streets)
    {
        this.streets = streets;
    }

    public Street addStreet(Street street)
    {
        getStreets().add(street);
        street.setRegion(this);

        return street;
    }

    public Street removeStreet(Street street)
    {
        getStreets().remove(street);
        street.setRegion(null);

        return street;
    }

}
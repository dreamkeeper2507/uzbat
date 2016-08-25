package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the person database table.
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person extends AbstractUzBatEntity
{

    private String personFName;

    private String personLName;

    private String personPName;


    @ManyToMany
    @JoinTable(
            name = "person_phone"
            , joinColumns = {
            @JoinColumn(name = "id")
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "id")
    }
    )
    private List<Phone> phones;

    public Person()
    {
    }

    public String getPersonFName()
    {
        return this.personFName;
    }

    public void setPersonFName(String personFName)
    {
        this.personFName = personFName;
    }

    public String getPersonLName()
    {
        return this.personLName;
    }

    public void setPersonLName(String personLName)
    {
        this.personLName = personLName;
    }

    public String getPersonPName()
    {
        return this.personPName;
    }

    public void setPersonPName(String personPName)
    {
        this.personPName = personPName;
    }

    public List<Phone> getPhones()
    {
        return this.phones;
    }

    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }

}
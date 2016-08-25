package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the phone database table.
 */
@Entity
@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
public class Phone extends AbstractUzBatEntity
{


    private String phoneNumber;

    //bi-directional many-to-many association to Person
    @ManyToMany(mappedBy = "phones")
    private List<Person> persons;

    public Phone()
    {
    }


    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public List<Person> getPersons()
    {
        return this.persons;
    }

    public void setPersons(List<Person> persons)
    {
        this.persons = persons;
    }

}
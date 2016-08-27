package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the phone database table.
 */
@Entity
@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
public class Phone implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PHONE_ID_GENERATOR", sequenceName = "PHONE_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_ID_GENERATOR")
    private Long id;

    private String phoneNumber;

    // bi-directional many-to-many association to Person
    @ManyToMany(mappedBy = "phones")
    private List<Person> persons;

    public Phone()
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
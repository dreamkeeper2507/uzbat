package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the person database table.
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PERSON_ID_GENERATOR", sequenceName = "PERSON_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID_GENERATOR")
    private Long id;

    private String personFName;

    private String personLName;

    private String personPName;

    // bi-directional many-to-many association to Phone
    @ManyToMany
    @JoinTable(name = "person_phone", joinColumns = {@JoinColumn(name = "person_id")}, inverseJoinColumns = {@JoinColumn(name = "phone_id")})
    private List<Phone> phones;

    // bi-directional many-to-one association to Store
    @OneToMany(mappedBy = "person")
    private List<Store> stores;

    // bi-directional many-to-one association to Supplier
    @OneToMany(mappedBy = "person")
    private List<Supplier> suppliers;

    // bi-directional many-to-one association to UserProfile
    @OneToMany(mappedBy = "personBean")
    private List<UserProfile> userprofiles;

    public Person()
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

    public List<Store> getStores()
    {
        return this.stores;
    }

    public void setStores(List<Store> stores)
    {
        this.stores = stores;
    }

    public Store addStore(Store store)
    {
        getStores().add(store);
        store.setPerson(this);

        return store;
    }

    public Store removeStore(Store store)
    {
        getStores().remove(store);
        store.setPerson(null);

        return store;
    }

    public List<Supplier> getSuppliers()
    {
        return this.suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers)
    {
        this.suppliers = suppliers;
    }

    public Supplier addSupplier(Supplier supplier)
    {
        getSuppliers().add(supplier);
        supplier.setPerson(this);

        return supplier;
    }

    public Supplier removeSupplier(Supplier supplier)
    {
        getSuppliers().remove(supplier);
        supplier.setPerson(null);

        return supplier;
    }

    public List<UserProfile> getUserprofiles()
    {
        return this.userprofiles;
    }

    public void setUserprofiles(List<UserProfile> userprofiles)
    {
        this.userprofiles = userprofiles;
    }

    public UserProfile addUserprofile(UserProfile userprofile)
    {
        getUserprofiles().add(userprofile);
        userprofile.setPersonBean(this);

        return userprofile;
    }

    public UserProfile removeUserprofile(UserProfile userprofile)
    {
        getUserprofiles().remove(userprofile);
        userprofile.setPersonBean(null);

        return userprofile;
    }

}
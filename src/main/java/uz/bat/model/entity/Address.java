package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the address database table.
 */
@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ADDRESS_ID_GENERATOR", sequenceName = "ADDRESS_SEQUENSE", allocationSize = 1)
    @GeneratedValue(generator = "ADDRESS_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    private String address;

    // bi-directional many-to-one association to Street
    @ManyToOne
    private Street street;

    // bi-directional many-to-one association to Store
    @OneToMany(mappedBy = "addressBean")
    private List<Store> stores;

    public Address() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Street getStreet() {
        return this.street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public List<Store> getStores() {
        return this.stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public Store addStore(Store store) {
        getStores().add(store);
        store.setAddressBean(this);

        return store;
    }

    public Store removeStore(Store store) {
        getStores().remove(store);
        store.setAddressBean(null);

        return store;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", street=" + street +
                ", stores=" + stores +
                '}';
    }
}
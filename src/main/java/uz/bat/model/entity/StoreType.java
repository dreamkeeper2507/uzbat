package uz.bat.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the storetype database table.
 */
@Entity
@NamedQuery(name = "StoreType.findAll", query = "SELECT s FROM StoreType s")
public class StoreType implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STORETYPE_ID_GENERATOR", sequenceName = "STORETYPE_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORETYPE_ID_GENERATOR")
    private Long id;

    private String description;

    private String typeName;

    // bi-directional many-to-one association to Store
    @OneToMany(mappedBy = "storetype")
    private List<Store> stores;

    public StoreType()
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

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTypeName()
    {
        return this.typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
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
        store.setStoretype(this);

        return store;
    }

    public Store removeStore(Store store)
    {
        getStores().remove(store);
        store.setStoretype(null);

        return store;
    }

}
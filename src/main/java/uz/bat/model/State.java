package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the state database table.
 */
@Entity
@NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
public class State implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STATE_ID_GENERATOR", sequenceName = "STATE_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_ID_GENERATOR")
    private Long id;

    private String code;

    private String name;

    // bi-directional many-to-one association to Region
    @OneToMany(mappedBy = "state")
    private List<Region> regions;

    // bi-directional many-to-one association to Country
    @ManyToOne
    private Country country;

    public State()
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

    public List<Region> getRegions()
    {
        return this.regions;
    }

    public void setRegions(List<Region> regions)
    {
        this.regions = regions;
    }

    public Region addRegion(Region region)
    {
        getRegions().add(region);
        region.setState(this);

        return region;
    }

    public Region removeRegion(Region region)
    {
        getRegions().remove(region);
        region.setState(null);

        return region;
    }

    public Country getCountry()
    {
        return this.country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

}
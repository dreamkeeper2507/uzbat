package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the country database table.
 */
@Entity
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "COUNTRY_ID_GENERATOR", sequenceName = "COUNTRY_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_ID_GENERATOR")
    private Long id;

    private String code;

    private String name;

    // bi-directional many-to-one association to State
    @OneToMany(mappedBy = "country")
    private List<State> states;

    public Country()
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

    public List<State> getStates()
    {
        return this.states;
    }

    public void setStates(List<State> states)
    {
        this.states = states;
    }

    public State addState(State state)
    {
        getStates().add(state);
        state.setCountry(this);

        return state;
    }

    public State removeState(State state)
    {
        getStates().remove(state);
        state.setCountry(null);

        return state;
    }

}
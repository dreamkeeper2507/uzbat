package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the role database table.
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ROLE_ID_GENERATOR", sequenceName = "ROLE_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_GENERATOR")
    private Long id;

    private String name;

    // bi-directional many-to-many association to User
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role()
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<User> getUsers()
    {
        return this.users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

}
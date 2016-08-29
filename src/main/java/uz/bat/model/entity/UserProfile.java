package uz.bat.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the userprofile database table.
 */
@Entity
@NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
public class UserProfile implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USERPROFILE_ID_GENERATOR", sequenceName = "USERPROFILE_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERPROFILE_ID_GENERATOR")
    private Long id;

    // bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "user")
    private User userBean;

    // bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "person")
    private Person personBean;

    public UserProfile()
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

    public User getUserBean()
    {
        return this.userBean;
    }

    public void setUserBean(User userBean)
    {
        this.userBean = userBean;
    }

    public Person getPersonBean()
    {
        return this.personBean;
    }

    public void setPersonBean(Person personBean)
    {
        this.personBean = personBean;
    }

}
package uz.bat.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user database table.
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    private Long id;

    private String password;

    private String username;

    // bi-directional many-to-many association to Role
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    // bi-directional many-to-one association to UserProfile
    @OneToMany(mappedBy = "userBean")
    private List<UserProfile> userprofiles;

    public User()
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

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<Role> getRoles()
    {
        return this.roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
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
        userprofile.setUserBean(this);
        return userprofile;
    }

    public UserProfile removeUserprofile(UserProfile userprofile)
    {
        getUserprofiles().remove(userprofile);
        userprofile.setUserBean(null);

        return userprofile;
    }

}
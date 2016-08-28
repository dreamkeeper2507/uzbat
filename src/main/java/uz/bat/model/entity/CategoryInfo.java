package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the categoryinfo database table.
 */
@Entity
@NamedQuery(name = "CategoryInfo.findAll", query = "SELECT c FROM CategoryInfo c")
public class CategoryInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CATEGORYINFO_ID_GENERATOR", sequenceName = "CATEGORYINFO_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORYINFO_ID_GENERATOR")
    private Long id;

    private String descroption;

    private String infoname;

    // bi-directional many-to-many association to Category
    @ManyToMany(mappedBy = "categoryinfos")
    private List<Category> categories;

    public CategoryInfo()
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

    public String getDescroption()
    {
        return this.descroption;
    }

    public void setDescroption(String descroption)
    {
        this.descroption = descroption;
    }

    public String getInfoname()
    {
        return this.infoname;
    }

    public void setInfoname(String infoname)
    {
        this.infoname = infoname;
    }

    public List<Category> getCategories()
    {
        return this.categories;
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

}
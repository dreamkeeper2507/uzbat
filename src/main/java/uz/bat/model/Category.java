package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category extends AbstractUzBatEntity
{
    private String name;

    public Category()
    {
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
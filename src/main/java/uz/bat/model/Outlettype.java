package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the outlettype database table.
 */
@Entity
@NamedQuery(name = "Outlettype.findAll", query = "SELECT o FROM Outlettype o")
public class Outlettype extends AbstractUzBatEntity
{
    private String type;

    public Outlettype()
    {
    }


    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}
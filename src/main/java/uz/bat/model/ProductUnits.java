package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productunits database table.
 */
@Entity
@Table(name = "productunits")
@NamedQuery(name = "Productunit.findAll", query = "SELECT p FROM ProductUnits p")
public class ProductUnits extends AbstractUzBatEntity
{


    private String unitName;

    public ProductUnits()
    {
    }


    public String getUnitName()
    {
        return this.unitName;
    }

    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }

}
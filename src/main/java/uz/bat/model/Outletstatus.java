package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the outletstatus database table.
 */
@Entity
@NamedQuery(name = "Outletstatus.findAll", query = "SELECT o FROM OutletStatus o")
public class OutletStatus extends AbstractUzBatEntity
{
    private String status;

    public OutletStatus()
    {
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
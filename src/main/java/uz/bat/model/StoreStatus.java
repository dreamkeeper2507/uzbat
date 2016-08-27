package uz.bat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the store_statuses database table.
 */
@Entity
@Table(name = "store_statuses")
@NamedQuery(name = "StoreStatus.findAll", query = "SELECT s FROM StoreStatus s")
public class StoreStatus implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "STORE_STATUSES_ID_GENERATOR", sequenceName = "STORE_STATUSES_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_STATUSES_ID_GENERATOR")
    private Long id;

    private String statusName;

    public StoreStatus()
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

    public String getStatusName()
    {
        return this.statusName;
    }

    public void setStatusName(String statusName)
    {
        this.statusName = statusName;
    }

}
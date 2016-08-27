package uz.bat.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the period database table.
 */
@Entity
@NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p")
public class Period implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PERIOD_ID_GENERATOR", sequenceName = "PERIOD_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERIOD_ID_GENERATOR")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Period()
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

    public Date getBeginDate()
    {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

}
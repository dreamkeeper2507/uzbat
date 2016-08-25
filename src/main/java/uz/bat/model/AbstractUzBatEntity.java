package uz.bat.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Khusan on 24.08.2016.
 */
@MappedSuperclass
public abstract class AbstractUzBatEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}

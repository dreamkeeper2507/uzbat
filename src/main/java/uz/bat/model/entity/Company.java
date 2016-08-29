package uz.bat.model.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the company database table.
 */
@Entity
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
public class Company implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "COMPANY_ID_GENERATOR", sequenceName = "COMPANY_SEQUENSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_ID_GENERATOR")
    private Long id;

    private String companyName;

    private String description;

    // bi-directional many-to-one association to Brand
    @OneToMany(mappedBy = "companyBean")
    private List<Brand> brands;

    public Company()
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

    public String getCompanyName()
    {
        return this.companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Brand> getBrands()
    {
        return this.brands;
    }

    public void setBrands(List<Brand> brands)
    {
        this.brands = brands;
    }

    public Brand addBrand(Brand brand)
    {
        getBrands().add(brand);
        brand.setCompanyBean(this);

        return brand;
    }

    public Brand removeBrand(Brand brand)
    {
        getBrands().remove(brand);
        brand.setCompanyBean(null);

        return brand;
    }

}
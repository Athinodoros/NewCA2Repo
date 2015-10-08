package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author favl
 */
@Entity
public class Address implements Serializable
{
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private String additionalInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    private CityInfo cityInfo;
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<InfoEntity> habitants = new ArrayList();

    public Address()
    {
    }

    public Address(String streetName, String additionalInfo, CityInfo cityInfo)
    {
        this.streetName = streetName;
        this.additionalInfo = additionalInfo;
        this.cityInfo = cityInfo;
    }
    
    public void addHabitantToAddress(InfoEntity entity)
    {
        habitants.add(entity);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }

    public CityInfo getCityInfo()
    {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo)
    {
        this.cityInfo = cityInfo;
    }

    public List<InfoEntity> getHabitants()
    {
        return habitants;
    }

    public void setHabitants(List<InfoEntity> habitants)
    {
        this.habitants = habitants;
    }
    
    
}

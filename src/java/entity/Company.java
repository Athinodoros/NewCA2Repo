package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author favl
 */
@NamedQueries({
    @NamedQuery(name = "Company.findByCvr", query = "SELECT c FROM Company c WHERE c.cvr = :cvr"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByMarketValue", query = "SELECT c FROM Company c WHERE c.marketValue = :marketValue"),
    @NamedQuery(name = "Company.findByNumOfEmployees", query = "SELECT c FROM Company c WHERE c.numOfEmployees = :numOfEmployees"),
    @NamedQuery(name = "Company.findByPhone", query = "SELECT c FROM Company c WHERE c.phones = :phones")
})
@Entity
public class Company extends InfoEntity implements Serializable
{
//    private static final long serialVersionUID = 1L;
    

    private String name;
    private String description;
    private int cvr;
    private int numOfEmployees;
    private String marketValue; //Not sure about the datatype here. You might want to ask a teacher.

    public Company()
    {
    }

    public Company(String name, String description, int cvr, int numOfEmployees, String marketValue, String email, Address address)
    {
        super(email, address);
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numOfEmployees = numOfEmployees;
        this.marketValue = marketValue;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCvr()
    {
        return cvr;
    }

    public void setCvr(int cvr)
    {
        this.cvr = cvr;
    }

    public int getNumOfEmployees()
    {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees)
    {
        this.numOfEmployees = numOfEmployees;
    }

    public String getMarketValue()
    {
        return marketValue;
    }

    public void setMarketValue(String marketValue)
    {
        this.marketValue = marketValue;
    }

    
}

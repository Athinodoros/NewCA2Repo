
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
 * @author Rihards
 */
@Entity
public abstract class InfoEntity implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    //@JoinTable(name = "INFOENTITY_PHONE")
    @OneToMany(mappedBy = "infoEntity", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList();
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    public InfoEntity()
    {
    }

    public InfoEntity(String email, Address address)
    {
        this.email = email;
        this.address = address;
    }

    public void addPhoneToEntity(Phone phone)
    {
        phone.setInfoEntity(this);
        phones.add(phone);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    
}

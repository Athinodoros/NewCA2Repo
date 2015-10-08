/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Athinodoros
 */
@Entity
public class Phone implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int phoneNumber;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private InfoEntity infoEntity;

    public Phone()
    {
    }

    public Phone(int phoneNumber, String description)
    {
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public InfoEntity getInfoEntity()
    {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity)
    {
        this.infoEntity = infoEntity;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Athinodoros
 */
public class AddresFacade {
     private EntityManagerFactory emf;
    
    public AddresFacade(EntityManagerFactory e)
    {
        this.emf = e;
    }
    
    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
//    
//    public CityInfo getCityInformation(int zipCode)
//    {
//        EntityManager em = getEntityManager();
//        try {
//            Query query = em.createNamedQuery("CityInfo.findByZipCode");
//            query.setParameter("zipCode", zipCode);
//            //insert exception handling here
//            return (CityInfo) query.getSingleResult();
//        } finally {
//            em.close();
//        }
//    }
    
 
    public Address createAddress(Address add)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(add);
            em.getTransaction().commit();
            return add;
        } finally {
            em.close();
        }
    }


    public Address getAddress(int id)
    {
        EntityManager em = getEntityManager();
        try {
          Address ad = em.find(Address.class, id);
            //insert exception handling here
            return ad;
        } finally {
            em.close();
        }
    }


    public Address updateAddress(Address comp)
    {
        EntityManager em = getEntityManager();
        try {
            Address updated = em.find(Address.class, comp.getId());
            //insert exception handling here
            //updated.addHabitantToAddress(comp.g());
            updated.setCityInfo(comp.getCityInfo());
            updated.setStreetName(comp.getStreetName());
            updated.setHabitants(comp.getHabitants());
            updated.setAdditionalInfo(comp.getAdditionalInfo());
//            updated.setNumOfEmployees(comp.getNumOfEmployees());
//            updated.setEmail(comp.getEmail());
//            updated.setPhones(comp.getPhones());
            em.getTransaction().begin();
            em.merge(updated);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    
    public Address deleteAddress(long cvr)
    {
        EntityManager em = getEntityManager();
        try {
//            Query query = em.createNamedQuery("Company.findByCvr");
//            query.setParameter("cvr", cvr);
            //insert exception handling here
            Address address = em.find(Address.class, cvr);
            //insert exception handling here
            em.getTransaction().begin();
            em.remove(address);
            em.getTransaction().commit();
            return address;
        } finally {
            em.close();
        }
    }
//    @Override
//    public Company deleteCompanyById(long cvr)
//    {
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            Company company = em.find(Company.class, (long)cvr);
//            em.remove(company);
//            em.getTransaction().commit();
//            return company;
//        } finally {
//            em.close();
//        }
//    }

    
    public List<Address> getAddress()
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Address c").getResultList();
        } finally {
            em.close();
        }
    }
}

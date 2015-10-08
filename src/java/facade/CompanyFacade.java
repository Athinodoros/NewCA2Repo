package facade;

import entity.CityInfo;
import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author favl
 */
public class CompanyFacade implements CompanyInterface
{
    private EntityManagerFactory emf;
    
    public CompanyFacade(EntityManagerFactory e)
    {
        this.emf = e;
    }
    
    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
    @Override
    public CityInfo getCityInformation(int zipCode)
    {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("");
            //insert exception handling here
            return null;
        } finally {
            em.close();
        }
    }
    
    @Override
    public Company createCompany(Company comp)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(comp);
            em.getTransaction().commit();
            return comp;
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompany(int cvr)
    {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("Company.findByCvr");
            query.setParameter("cvr", cvr);
            //insert exception handling here
            return (Company) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Company updateCompany(Company comp)
    {
        EntityManager em = getEntityManager();
        try {
            Company updated = em.find(Company.class, comp.getId());
            //insert exception handling here
            updated.setName(comp.getName());
            updated.setAddress(comp.getAddress());
            updated.setCvr(comp.getCvr());
            updated.setDescription(comp.getDescription());
            updated.setMarketValue(comp.getMarketValue());
            updated.setNumOfEmployees(comp.getNumOfEmployees());
            updated.setEmail(comp.getEmail());
            updated.setPhones(comp.getPhones());
            em.getTransaction().begin();
            em.merge(updated);
            em.getTransaction().commit();
            return updated;
        } finally {
            em.close();
        }
    }

    @Override
    public Company deleteCompany(Company comp)
    {
        EntityManager em = getEntityManager();
        try {
            Company c = em.find(Company.class, comp.getId());
            //insert exception handling here
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies()
    {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Company c").getResultList();
        } finally {
            em.close();
        }
    }

}
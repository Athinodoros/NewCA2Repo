package JUnit;

import deploy.DeploymentConfiguration;
import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Phone;
import facade.CompanyFacade;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Rihards
 */
public class TestCompanyFacade
{

    CompanyFacade cf;

    public TestCompanyFacade()
    {
        cf = new CompanyFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
    }

    @Test
    public void testGetCityInformation()
    {
        CityInfo cityinfo = cf.getCityInformation(2700);
        Assert.assertNotNull(cityinfo.getzipCode());
    }
    
    @Test
    public void testCreateCompany()
    {
        
        CityInfo cityinfo = cf.getCityInformation(2700);
        Phone p1 = new Phone(23728394, "Freddy's Phone");
        Phone p2 = new Phone(20962783, "Line's Phone");
        Phone p3 = new Phone(48484848, "Taxi Nordsjl");
        Company c = new Company("testCompany", "testDescription", 12345678, 20,
                "testMarketValue", "test@mail.com", new Address("testStreet",
                        "testAdditionalInfo", cityinfo));
        c.addPhoneToEntity(p1);
        c.addPhoneToEntity(p2);
        c.addPhoneToEntity(p3);
        cf.createCompany(c);
        Assert.assertNotNull(c.getId());
    }
    
    @Test
    public void testGetCompanyByCvr()
    {
        Company company = cf.getCompany(12345678);
        Assert.assertEquals(12345678, company.getCvr());
    }

}

package JUnit;

import entity.Company;
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
        cf = new CompanyFacade(Persistence.createEntityManagerFactory("CA2PU2"));
    }

    @Test
    public void testCreateCompany()
    {
////        CityInfo cityinfo = cf.getCityInformation(2700); //NOT PRIMARY KEY!!
//        Phone p1 = new Phone(23728394, "Freddy's Phone");
//        Phone p2 = new Phone(20962783, "Line's Phone");
//        Phone p3 = new Phone(48484848, "Taxi Nordsjl");
//        Company c = new Company("testCompany", "testDescription", 12345678, 20,
//                "testMarketValue", "test@mail.com", new Address("testStreet",
//                        "testAdditionalInfo", new CityInfo(9999, "testCity")));
//        c.addPhoneToEntity(p1);
//        c.addPhoneToEntity(p2);
//        c.addPhoneToEntity(p3);
//        cf.createCompany(c);
//        Assert.assertNotNull(c.getId());
    }
    
    @Test
    public void testGetCompanyByCvr()
    {
        Company company = cf.getCompany(6606000);
        Assert.assertEquals(6606000, company.getCvr());
    }

}

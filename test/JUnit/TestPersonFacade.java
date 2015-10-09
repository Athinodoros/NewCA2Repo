package JUnit;

import deploy.DeploymentConfiguration;
import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
import facade.PersonFacade;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author favl
 */
public class TestPersonFacade
{
    PersonFacade pf;
    
    public TestPersonFacade()
    {
        pf = new PersonFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
    }

    @Test
    public void testCreatePerson()
    {
//        CityInfo cityinfo = pf.getCityInformation(2700);
        Person person = new Person("testFirstName", "testLastName", "test@test.dk", 
                        new Address("testStreetName", "testAdditionalInfo info info", 
                        new CityInfo(2970, "Hørsholm")));
        Phone phone1 = new Phone(88888888, "this is a number with 8's");
        Phone phone2 = new Phone(99999999, "this is a number with 9's");
        person.addPhoneToEntity(phone1);
        person.addPhoneToEntity(phone2);
        pf.createPerson(person);
        System.out.println("Person ID: " + person.getId());
        Assert.assertNotNull(person.getId());
    }
}

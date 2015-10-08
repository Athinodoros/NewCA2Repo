package facade;

import entity.CityInfo;
import entity.Person;
import exception.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author Rihards
 */
public interface PersonInterface
{

    public CityInfo getCityInformation(int zipCode);
    public Person createPerson(Person p);
    public Person deletePerson(long id)throws PersonNotFoundException;;
    public Person updatePerson(Person p)throws PersonNotFoundException;;
    public Person getPerson (long id)throws PersonNotFoundException;;
    public List<Person> getPersons ();
}

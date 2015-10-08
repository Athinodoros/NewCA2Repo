package facade;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Address;
import entity.Company;
import entity.Person;
import entity.Phone;
import java.util.List;

/**
 *
 * @author favl
 */
public class JSONconverter {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public static Company getCompanyFromJSON(String json) //CREATING, EDITING COMPANY
    {
        return gson.fromJson(json, Company.class);
    }

    public static String getJSONFromCompany(Company co) //READING, DELETING COMPANY
    {
        return gson.toJson(co);
    }

    public static String getJSONFromCompany(List<Company> companies) //GET LIST
    {
        
        for (Company person : companies) {
            JsonObject jo = new JsonObject();
            jo.addProperty("Name", person.getName());
            jo.addProperty("description", person.getDescription());
            jo.addProperty("email", person.getEmail());
            jo.addProperty("cvr", person.getCvr());
            jo.addProperty("numOfEmployees", person.getNumOfEmployees());
            jo.addProperty("marketValue", person.getMarketValue());
            jo.addProperty("street", person.getAddress().getStreetName());
            jo.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
            jo.addProperty("zipCode", person.getAddress().getCityInfo().getzipCode());
            jo.addProperty("city", person.getAddress().getCityInfo().getCity());
            JsonArray phones = new JsonArray();
            for (Phone phone : person.getPhones()) {
                JsonObject phone1 = new JsonObject();
                phone1.addProperty("number", phone.getPhoneNumber());
                phone1.addProperty("description", phone.getDescription());
                phones.add(phone1);
            }
            jo.add("phones", phones);
            String jsonStr = gson.toJson(jo); //The JSON string is ready
            
        }
        return gson.toJson(companies);
    }

    public static Person getPersonFromJSON(String json) //CREATING, EDITING Person
    {
        return gson.fromJson(json, Person.class);
    }

    public static String getJSONFromPerson(Person p) //READING, DELETING Person
    {
        return gson.toJson(p);
    }

    public static String getJSONFromPerson(List<Person> persons) //GET LIST
    {
        for (Person person : persons) {
            JsonObject jo = new JsonObject();
            jo.addProperty("firstName", person.getFirstName());
            jo.addProperty("lastName", person.getLastName());
            jo.addProperty("email", person.getEmail());
            jo.addProperty("street", person.getAddress().getStreetName());
            jo.addProperty("additionalInfo", person.getAddress().getAdditionalInfo());
            jo.addProperty("zipCode", person.getAddress().getCityInfo().getzipCode());
            jo.addProperty("city", person.getAddress().getCityInfo().getCity());
            JsonArray phones = new JsonArray();
            for (Phone phone : person.getPhones()) {
                JsonObject phone1 = new JsonObject();
                phone1.addProperty("number", phone.getPhoneNumber());
                phone1.addProperty("description", phone.getDescription());
                phones.add(phone1);
            }
            jo.add("phones", phones);
            String jsonStr = gson.toJson(jo); //The JSON string is ready
            
        }
        return gson.toJson(persons);
    }

    /////////////////////////////////////////////////////////////////////

    public static Address getAddressFromJSON(String json) //CREATING, EDITING Person
    {
        return gson.fromJson(json, Address.class);
    }

    public static String getJSONFromAddress(Address p) //READING, DELETING Person
    {
        return gson.toJson(p);
    }

    public static String getJSONFromAddress(List<Address> address) //GET LIST
    {
        return gson.toJson(address);
    }
    /////////////////////////////////////////////////////////////////////
}

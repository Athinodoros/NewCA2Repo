package RESTassured;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.defaultParser;
import com.jayway.restassured.parsing.Parser;
import entity.Address;
import entity.Person;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author favl
 */
public class TestCRUDpersonAPI
{
    @BeforeClass
    public static void setUpClass()
    {
        baseURI = "http://localhost:8080";
        defaultParser = Parser.JSON;
        basePath = "/CA2/api/person";
    }

    public TestCRUDpersonAPI()
    {
    }

    
    @Test
    public void testPOST()
    {
        Person person = new Person("restTESTfName", "restTESTlName", "rest@TEST.com", 
                        new Address("restTESTstreet", "This is a restTEST address", 
                        null));
        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(person)
                .when()
                .post()
                .then()
                .body("firstName", equalTo(person.getFirstName()));
    }

    @Test
    public void testGET1()
    {
        RestAssured
                .get("/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstName", is("Lance"));
    }

    @Test
    public void testGET2()
    {
        RestAssured
                .get("/all")
                .then()
                .body("id", hasItems(1, 2, 3));
    }

    @Test
    public void testDELETE()
    {
        RestAssured
                .delete("/4")
                .then()
                .assertThat()
                .statusCode(200);
    }

}

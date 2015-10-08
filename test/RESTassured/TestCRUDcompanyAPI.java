package RESTassured;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.defaultParser;
import com.jayway.restassured.parsing.Parser;
import entity.Address;
import entity.Company;
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
public class TestCRUDcompanyAPI
{
    @BeforeClass
    public static void setUpClass()
    {
        baseURI = "http://localhost:8080";
        defaultParser = Parser.JSON;
        basePath = "/CA2/api/company";
    }

    public TestCRUDcompanyAPI()
    {
    }

    
    @Test
    public void testPOST()
    {
        Company company = new Company("restTESTname", "this is a restTEST description", 
                          99999999, 30, "testREST marketValue", "rest@assured.com", 
                          new Address("rest assured", "I assure you", 
                          null));
        
        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(company)
                .when()
                .post()
                .then()
                .body("cvr", equalTo(company.getCvr()));
    }

    @Test
    public void testGET1()
    {
        RestAssured
                .get("/102")
                .then()
                .assertThat()
                .statusCode(200)
                .body("cvr", is(44592724));
    }

    @Test
    public void testGET2()
    {
        RestAssured
                .get("/all")
                .then()
                .body("id", hasItems(110, 120, 130));
    }

    @Test
    public void testDELETE()
    {
        RestAssured
                .delete("/150")
                .then()
                .assertThat()
                .statusCode(200);
    }

}

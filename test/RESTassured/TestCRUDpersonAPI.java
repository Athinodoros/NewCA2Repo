package RESTassured;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.defaultParser;
import com.jayway.restassured.parsing.Parser;
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
    public void testCreateUser()
    {
        ProjectUser user = new ProjectUser();
        user.setUserName("testFirstName");
        user.setEmail("test@Email.com");
        user.setCreated(new java.util.Date());
        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .when()
                .post()
                .then()
                .body("userName", equalTo(user.getUserName()));
    }

    @Test
    public void testGetUser()
    {
        RestAssured
                .get("/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("userName", is("sofus"));
    }

    @Test
    public void testGetUsers()
    {
        RestAssured
                .get("/")
                .then()
                .body("id", hasItems(1, 2, 3));
    }

    @Test
    public void testDeleteUser()
    {
        RestAssured
                .delete("/6")
                .then()
                .assertThat()
                .statusCode(200);
    }

}

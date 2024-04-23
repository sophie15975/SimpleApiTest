package tests.junit5.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;

public class SimpleApiRefactoredTests {
    @BeforeAll

    public static void  setUp() {
        System.out.println("----------------------------");
        //RestAssured.baseURI = "https://fakestoreapi.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test
    public void getAllUsersTest() {
        given().get("https://fakestoreapi.com/users")
                .then()
                .statusCode(200);

    }

}

package tests.swaggerTests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class UserTests {
//    @BeforeAll
//    public static void setUp(){
//        RestAssured.baseURI = "http://85.192.34.140:8080";
//        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//    }


    @Test
    public void getAllUsersTest() {
        given().get("/api/signup")
                .then()
                .statusCode(200);

    }
    }


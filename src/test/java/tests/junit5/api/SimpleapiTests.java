package tests.junit5.api;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import models.fakeApiUser.Address;
import models.fakeApiUser.Geolocation;
import models.fakeApiUser.Name;
import models.fakeApiUser.UserRoot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class SimpleapiTests {




    @Test
    public void getSingleUserTest() {
        int userId = 5;
        given().pathParam("userId", userId)
                .get("https://fakestoreapi.com/users/{userId}")
                .then().log().all()
                .statusCode(200)
                .body("id", equalTo(userId))
                .body("address.zipcode", matchesPattern("\\d{5}-\\d{4}"));
    }
    @ParameterizedTest
    @ValueSource(ints = { 1, 10})
    public void getAllUsersWithLimitTest(int limitSize) {

        List<UserRoot> users = given()
                .queryParam("limit", limitSize)
                .get("https://fakestoreapi.com/users")
                .then().log().all()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<UserRoot>>() {
                });

        Assertions.assertEquals(limitSize, users.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    public void getAllUsersWithLimitErrorParams(int limitSize) {
        List<UserRoot> users = given()
                .queryParam("limit", limitSize)
                .get("https://fakestoreapi.com/users")
                .then().log().all()
                .statusCode(200)
                .extract().as(new TypeRef<List<UserRoot>>() {
                });

        Assertions.assertNotEquals(limitSize, users.size());
    }

    @Test
    public void getAllUsersSortByDescTest() {
        String sortType = "desc";

        Response sortedResponse = given().queryParam("sort", sortType)
                .get("https://fakestoreapi.com/users")
                .then().log().all()
                .extract().response();

        Response notSortedResponse = given()
                .get("https://fakestoreapi.com/users")
                .then().log().all()
                .extract().response();

        List<Integer> sortedResponseIds = sortedResponse.jsonPath().getList("id");
        List<Integer> notSortedResponseIds = notSortedResponse.jsonPath().getList("id");

//        List<Integer> sortedByCode = notSortedResponseIds
//                .stream()
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());

        Assertions.assertNotEquals(sortedResponseIds, notSortedResponseIds);
        //Assertions.assertEquals(sortedByCode, sortedResponseIds);
    }


//    @Test
//    public void addNewUserTest(){
//        Name name = new Name("Федор", "Достоевский");
//
//        Geolocation geoLocation = new Geolocation("-37.3159", "-37.3159");
//        Address address = new Address("12352-1152", 42, "спб", "new road", geoLocation);
//        UserRoot bodyReqest = new UserRoot("dqw@gmail.com" ,"Федя",  "123Qwerty" , name, address,"1-570-236-7033", 5,5  );
//        given().body(bodyReqest)
//                .post("https://fakestoreapi.com/users")
//                .then().log().all()
//                .statusCode(200)
//                .body("id", notNullValue());
//    }
//    private UserRoot getTestUser(){
//        Name name = new Name("Федор", "Достоевский");
//
//        Geolocation geoLocation = new Geolocation("-37.3159", "-37.3159");
//        Address address = new Address("12352-1152", 42, "спб", "new road", geoLocation);
//        return new UserRoot("dqw@gmail.com" ,"Федя",  "123" , name, address,"1-570-236-7033", 5,5  );
//
//
//    }
//    @Test
//    public void updateUserTest(){
//         UserRoot user = getTestUser();
//         String oldPassword = user.getPassword();
//         user.setPassword("123");
//         given().contentType("application/json").body(user)
//
//                 .put("https://fakestoreapi.com/users/"+user.getId())
//                 .then().log().all()
//                 .body("password", equalTo(oldPassword));
//    }

//    @Test
//    public void deleteUserTest(){
//
//        given().delete("https://fakestoreapi.com/users/7")
//                .then().log().all()
//                .statusCode(200);
//    }
//
//    @Test
//    public void authUserTest(){
//
//         Map<String, String> userAuth = new HashMap<>();
//
//        userAuth.put("username", "jimmie_k");
//        userAuth.put("password", "klein*#%*");
//
//        given().contentType(ContentType.JSON)
//                .body(userAuth)
//                .post("https://fakestoreapi.com/auth/login")
//                .then().log().all()
//                .statusCode(200)
//                .body("token", notNullValue());
//    }
}

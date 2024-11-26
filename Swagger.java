package Api_Automation;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Swagger {
    @Test
    public void CreateUser() {
        Response response = given().header("accept", " application/json").header("Content-Type", " application/json").body(

                "{\n" +
                        "  \"id\": 100,\n" +
                        "  \"username\": \"dharshanpl\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"12345\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}"
        ).when().post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(200, response.statusCode());
    }
    @Test
    public  void UserLogin(){
        Response res=given().header("accept","application/json")
//                .queryParam("un","dharshanpl")
//                .queryParam("pass","12345")
                .pathParams("un", "dharshanpl", "pass", "12345")
                .when()
//                .get("https://petstore.swagger.io/v2/user/login");// using query parameters
                .get("https://petstore.swagger.io/v2/user/login?username={un}&password={pass}");// using path parameters
        res.prettyPrint();
    }
    @Test
    public  void Logout(){
        Response res=given().header("accept","application/json")

                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        res.prettyPrint();
    }
    @Test
    public void UpdateUser() {

        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 200,\n" +
                        "  \"username\": \"dharshanpl\",\n" +
                        "  \"firstName\": \"Dharshan\",\n" +
                        "  \"lastName\": \"PL\",\n" +
                        "  \"email\": \"dharshan@gmail.com\",\n" +
                        "  \"password\": \"12345\",\n" +
                        "  \"phone\": \"9844480769\",\n" +
                        "  \"userStatus\": 250\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/dharshanpl");


        response.prettyPrint();


        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void GetUser() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/dharshanpl");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void createUsers() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 101,\n" +
                        "    \"username\": \"john1\",\n" +
                        "    \"firstName\": \"John\",\n" +
                        "    \"lastName\": \"Doe\",\n" +
                        "    \"email\": \"john.doe@example.com\",\n" +
                        "    \"password\": \"password123\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"jane2\",\n" +
                        "    \"firstName\": \"Jane\",\n" +
                        "    \"lastName\": \"Doe\",\n" +
                        "    \"email\": \"jane.doe@example.com\",\n" +
                        "    \"password\": \"password456\",\n" +
                        "    \"phone\": \"0987654321\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void createUser() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"john\",\n" +
                        "    \"firstName\": \"John\",\n" +
                        "    \"lastName\": \"Doe\",\n" +
                        "    \"email\": \"john.doe@example.com\",\n" +
                        "    \"password\": \"password123\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"jane\",\n" +
                        "    \"firstName\": \"Jane\",\n" +
                        "    \"lastName\": \"Doe\",\n" +
                        "    \"email\": \"jane.doe@example.com\",\n" +
                        "    \"password\": \"password456\",\n" +
                        "    \"phone\": \"0987654321\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"username\": \"Alice\",\n" +
                        "    \"firstName\": \"Alice\",\n" +
                        "    \"lastName\": \"Smith\",\n" +
                        "    \"email\": \"alice.smith@example.com\",\n" +
                        "    \"password\": \"password789\",\n" +
                        "    \"phone\": \"1122334455\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"username\": \"bob\",\n" +
                        "    \"firstName\": \"Bob\",\n" +
                        "    \"lastName\": \"Johnson\",\n" +
                        "    \"email\": \"bob.johnson@example.com\",\n" +
                        "    \"password\": \"password000\",\n" +
                        "    \"phone\": \"6677889900\",\n" +
                        "    \"userStatus\": 1\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void deleteUser() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/dharshanpl");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }





    @Test
    public void createOrder() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 101,\n" +
                        "  \"quantity\": 2,\n" +
                        "  \"shipDate\": \"2024-11-18T08:37:20.163Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getInventory() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void getOrder() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void deleteOrder() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createPet() {
        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 10,\n" +
                "    \"name\": \"Dogs\"\n" +
                "  },\n" +
                "  \"name\": \"Doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://example.com/photo1.jpg\",\n" +
                "    \"https://example.com/photo2.jpg\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 100,\n" +
                "      \"name\": \"cute\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 101,\n" +
                "      \"name\": \"playful\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void updatePet() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Dog\"\n" +
                        "  },\n" +
                        "  \"name\": \"Buddy\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"https://example.com/buddy.jpg\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1,\n" +
                        "      \"name\": \"friendly\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 2,\n" +
                        "      \"name\": \"playful\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void findPetsByStatus() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void findPetById() {

        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void postByPetId() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{ \"id\": 2, \"name\": \"Puff\", \"status\": \"available\" }")

                .when()
                .post("https://petstore.swagger.io/v2/pet");


        response.prettyPrint();


        response.then().assertThat().statusCode(200);
    }

    @Test
    public void uploadPetImage() {


        File imageFile = new File("C:\\Users\\dhars\\OneDrive\\Desktop\\Dog Happy New Year Pets.jpg");

        Response response = given()
                .accept("application/json")
                .contentType("multipart/form-data")
                .multiPart("file", imageFile)
                .when()
                .post("https://petstore.swagger.io/v2/pet/1/uploadImage");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
package Api_Automation;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DataBase_json {

    @Test
    public void post() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": \"1\",\n" +
                        "  \"title\": \"manual testing\",\n" +
                        "  \"author\": \"Dharshan P L\"\n" +
                        "}")
                .when()
                .post("http://localhost:3000/posts");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void put() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": \"1\",\n" +
                        "  \"title\": \"AutoMation Testing\",\n" +
                        "  \"author\": \"Dharshan P L\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/posts/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void delete() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("http://localhost:3000/posts/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void get() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("http://localhost:3000/posts");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void postComment() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": \"6\",\n" +
                        "  \"body\": \"new extra comment\",\n" +
                        "  \"postId\": \"1\"\n" +
                        "}")
                .when()
                .post("http://localhost:3000/comments");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 201);
    }


    @Test
    public void getComments() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("http://localhost:3000/comments");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void updateComment() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": \"1\",\n" +
                        "  \"body\": \"updated extra comment\",\n" +
                        "  \"postId\": \"2\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/comments/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void deleteComment() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("http://localhost:3000/comments/1");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void postProfile() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"New Code\"\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 404);
    }


    @Test
    public void getProfile() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get("http://localhost:3000/profile");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void updateProfile() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"Updated Code\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void deleteProfile() {
        Response response = given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("http://localhost:3000/profile");

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}

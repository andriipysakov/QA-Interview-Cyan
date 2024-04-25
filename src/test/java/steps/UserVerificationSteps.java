package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class UserVerificationSteps {
    private Response response;

    @Given("I send a GET request to {string}")
    public void iSendAGetRequestTo(String url) {
        response = given().when().get(url);
        response.then().assertThat()
                .statusCode(200);
    }

    @Then("I verify user {string} exists")
    public void iVerifyUserExists(String username) {
        assertTrue("User does not exist", response.body().asString().contains(username));
    }

    @Then("I verify user {string} address contains data")
    public void iVerifyUserAddressContainsData(String username) {
        String userAddressPath = "find { it.name == '" + username + "' }.address";
        Assert.assertEquals("Ellsworth Summit", response.jsonPath().getString(userAddressPath + ".street"));
        Assert.assertEquals("Suite 729", response.jsonPath().getString(userAddressPath + ".suite"));
        Assert.assertEquals("Aliyaview", response.jsonPath().getString(userAddressPath + ".city"));
        Assert.assertEquals("45169", response.jsonPath().getString(userAddressPath + ".zipcode"));
        Assert.assertEquals("-14.3990", response.jsonPath().getString(userAddressPath + ".geo.lat"));
        Assert.assertEquals("-120.7677", response.jsonPath().getString(userAddressPath + ".geo.lng"));
    }
}
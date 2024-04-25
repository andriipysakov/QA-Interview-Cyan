package steps;

import consts.ConstsAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpStatusCodeSteps {
    private Response response;

    @Given("I navigate to the page with multiple HTTP status codes {string}")
    public void iNavigateToThePageWithMultipleHTTPStatusCodesCode(String endpoint) {
        response = given()
                .redirects().follow(false)
                .baseUri(ConstsAPI.STATUS_CODE_URL)
                .basePath("/" + endpoint)
                .when()
                .get();
    }

    @Then("I should see the correct HTTP status code {int}")
    public void iShouldSeeTheCorrectHTTPStatusCode(int ResponseCode) {
        response.then().assertThat()
                .statusCode(ResponseCode);
    }
}

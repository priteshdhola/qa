package core.api.login;

import core.api.APIBasePage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import core.api.apiObjects.successfulLogin.successResponseObject;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Business logic for login API goes here
 */
public class loginAPI extends APIBasePage {
    RequestSpecification request;
    Response response;
    String errorResponse;
    successResponseObject successResponse;
    boolean isDebug = false;

    /**
     * Constructor where basic building blocks gets intitialzed
     */
    public loginAPI() {
        RestAssured.baseURI = super.getApiHostUrl() + "/l/account/api";
        request = RestAssured.given().
                contentType("application/x-www-form-urlencoded").
                accept(ContentType.JSON);
    }

    /**
     * Post call with body parms
     * @param params
     * @return
     */
    public Response loginAPIPostRequest(Map<String,String> params) {
        response = request.formParams(params).when().post("/login");
        if(isDebug) System.out.println(response.getBody().asString());

        return response;
    }

    /**
     * Get Response time of the request
     * @return
     */
    public long getResponseTime() {
        return response.getTime();
    }

    /**
     * Validate Login API Schema
     * @param params
     */
    public void validateAPIPostRequestScemaValidation(Map<String,String> params) {
        request.formParams(params).when().post("/login").
                then().
                body(matchesJsonSchemaInClasspath("schemaLoginApi.json")).
                body("success.user.username",equalTo(params.get("userName")));
    }

    /**
     * Parse a successful login
     * @param data
     * @return
     */
    public successResponseObject parseSuccess(Response data) {
        successResponse = data.as(successResponseObject.class);
        return successResponse;
    }

    /**
     * Parse an unsuccessful login
     * @param data
     * @return
     */
    public String parseError(Response data) {
        errorResponse = response.toString();
        return errorResponse;
    }

    /**
     * Verify a successful login
     */
    public void verifyLoginSuccessful() {
        assertEquals(successResponse.getSuccess().getUser().getUsername(),"automation_assignment");
    }

    public void allFieldsPresent() {
        assertEquals(successResponse.getSuccess().getUrl(),"");
    }

    /**
     * Verify a failed login
     */
    public void verifyLoginUnsuccessful() {
        if (errorResponse.contains("The username and password you entered don't match our records"))
            assertTrue(true,"Username of password does not match");
        else if (errorResponse.contains("\"username\":\"Required\"") && errorResponse.contains("\"password\":\"Required\""))
            assertTrue(true,"Username and password are required");
        else if (errorResponse.contains("\"password\":\"Required\""))
            assertTrue(true,"Password is required");
        else if (errorResponse.contains("\"userName\":\"Required\""))
            assertTrue(true,"Username is required");
        else
            assertTrue(true,"Something else has gone wrong");
    }
}


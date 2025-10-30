package practice_middle.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.LoginUserRequest;
import practice_middle.requests.CreateAccountRequester;
import practice_middle.requests.LoginUserRequester;

import java.util.List;

public class RequestSpecs {
    private RequestSpecs() {
    }

    private static RequestSpecBuilder defaultRequestBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:4111")
                .addFilters(List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    public static RequestSpecification unAuthUserSpec() {
        return defaultRequestBuilder().build();
    }

    public static RequestSpecification adminAuthSpec() {
        return defaultRequestBuilder()
                .addHeader("Authorization", "Basic YWRtaW46YWRtaW4=")
                .build();
    }

    public static RequestSpecification userAuthSpec(String username, String password) {
        String userToken = new LoginUserRequester(RequestSpecs.unAuthUserSpec(), ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(username)
                        .password(password)
                        .build())
                .extract()
                .header("Authorization");

        return defaultRequestBuilder()
                .addHeader("Authorization", userToken)
                .build();

    }


}
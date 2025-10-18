package ApiTests.practice_junior.helpers;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class CreateNewUserToken {
    public static String userAuthUnique(String name, String password) {
        if (UserSession.token != null && UserSession.username.equals(name)) {
            return UserSession.token;
        }
        // создание пользователя
        String bodyUser = String.format("""
                {
                  "username": "%s",
                  "password": "%s"
                }
                """, name, password);
        String bodyAdmin = String.format("""
                {
                  "username": "%s",
                  "password": "%s",
                  "role": "USER"
                }
                """, name, password);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46YWRtaW4=")
                .body(bodyAdmin)
                .post("http://localhost:4111/api/v1/admin/users");


//получаем токен
        String token = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyUser)
                .post("http://localhost:4111/api/v1/auth/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .header("Authorization");

        UserSession.username = name;
        UserSession.password = password;
        UserSession.token = token;
        return token;
    }

    public static String userAuthNonUnique() {
        // создание пользователя
        String name = "aA" + (int) (Math.random() * 1_000_000);
        if (name.length() > 15) {
            name = name.substring(0, 15);
        }
        String password = "Serega1!34";
        String bodyUser = String.format("""
                {
                  "username": "%s",
                  "password": "%s"
                }
                """, name, password);
        String bodyAdmin = String.format("""
                {
                  "username": "%s",
                  "password": "%s",
                  "role": "USER"
                }
                """, name, password);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46YWRtaW4=")
                .body(bodyAdmin)
                .post("http://localhost:4111/api/v1/admin/users");


//получаем токен
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyUser)
                .post("http://localhost:4111/api/v1/auth/login")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .header("Authorization");


    }
}
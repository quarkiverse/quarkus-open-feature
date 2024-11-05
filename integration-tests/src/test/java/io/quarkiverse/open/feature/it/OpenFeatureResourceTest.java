package io.quarkiverse.open.feature.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OpenFeatureResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/open-feature")
                .then()
                .statusCode(200)
                .body(is("Hello open-feature"));
    }
}

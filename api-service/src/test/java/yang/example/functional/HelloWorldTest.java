package yang.example.functional;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

public class HelloWorldTest extends FunctionalTest {

  @Test
  void shouldVerifyHelloWorldEndpoint() {
    when()
        .get("/helloWorld")
        .then()
        .statusCode(200)
        .body("message", is("Hello World!"));
  }
}

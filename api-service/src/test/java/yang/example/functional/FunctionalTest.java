package yang.example.functional;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class FunctionalTest {

  @LocalServerPort
  private int port;

  @BeforeEach
  public void setDefaultsForRestAssured() {
    RestAssured.port = port;
  }

  @AfterEach
  public void resetRestAssured() {
    RestAssured.reset();
  }

}

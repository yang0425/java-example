package yang.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepository {

  public String getHelloWorld() {
    return "Hello World!";
  }

}

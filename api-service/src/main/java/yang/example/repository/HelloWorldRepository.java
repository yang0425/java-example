package yang.example.repository;

import org.springframework.stereotype.Repository;
import yang.example.entity.HelloWorld;

@Repository
public class HelloWorldRepository {

  public HelloWorld getHelloWorld() {
    HelloWorld helloWorld = new HelloWorld();
    helloWorld.setMessage("Hello World!");
    return helloWorld;
  }

}

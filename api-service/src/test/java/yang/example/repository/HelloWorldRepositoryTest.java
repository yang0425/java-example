package yang.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloWorldRepositoryTest {

  private final HelloWorldRepository helloWorldRepository = new HelloWorldRepository();

  @Test
  void shouldReturnHelloWorld() {
    String helloWorld = helloWorldRepository.getHelloWorld();

    assertEquals("Hello World!", helloWorld);
  }
}
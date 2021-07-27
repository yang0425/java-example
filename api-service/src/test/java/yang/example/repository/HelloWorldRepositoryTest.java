package yang.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import yang.example.entity.HelloWorld;

class HelloWorldRepositoryTest {

    private final HelloWorldRepository helloWorldRepository = new HelloWorldRepository();

    @Test
    void shouldReturnHelloWorld() {
        HelloWorld helloWorld = helloWorldRepository.getHelloWorld();

        assertEquals("Hello World!", helloWorld.getMessage());
    }
}
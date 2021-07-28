package yang.example.repository;

import org.junit.jupiter.api.Test;
import yang.example.entity.HelloWorld;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldRepositoryTest {

    private final HelloWorldRepository helloWorldRepository = new HelloWorldRepository();

    @Test
    void shouldReturnHelloWorld() {
        HelloWorld helloWorld = helloWorldRepository.getHelloWorld();

        assertThat(helloWorld.getMessage()).isEqualTo("Hello World!");
    }
}
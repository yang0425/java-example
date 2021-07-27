package yang.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yang.example.dto.HelloWorldDto;
import yang.example.entity.HelloWorld;
import yang.example.repository.HelloWorldRepository;

@ExtendWith(MockitoExtension.class)
class HelloWorldServiceTest {

    @Mock
    private HelloWorldRepository helloWorldRepository;

    @InjectMocks
    private HelloWorldService helloWorldService;

    @Test
    void shouldGetMessageFromRepository() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World Test");
        when(helloWorldRepository.getHelloWorld()).thenReturn(helloWorld);

        HelloWorldDto helloWorldDto = helloWorldService.getHelloWorld();

        assertEquals("Hello World Test", helloWorldDto.getMessage());
    }
}
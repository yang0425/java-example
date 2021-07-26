package yang.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yang.example.dto.HelloWorldDTO;
import yang.example.repository.HelloWorldRepository;

@ExtendWith(MockitoExtension.class)
class HelloWorldServiceTest {

  @Mock
  private HelloWorldRepository helloWorldRepository;

  @InjectMocks
  private HelloWorldService helloWorldService;

  @Test
  void shouldGetMessageFromRepository() {
    when(helloWorldRepository.getHelloWorld()).thenReturn("Hello World Test");

    HelloWorldDTO helloWorld = helloWorldService.getHelloWorld();

    assertEquals("Hello World Test", helloWorld.getMessage());
  }
}
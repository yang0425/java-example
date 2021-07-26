package yang.example.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yang.example.service.HelloWorldService;

@ExtendWith(MockitoExtension.class)
class HelloWorldControllerTest {

  @Mock
  private HelloWorldService helloWorldService;

  @InjectMocks
  private HelloWorldController helloWorldController;

  @Test
  void shouldCallServiceAndGetHelloWorld() {
    helloWorldController.helloWorld();

    verify(helloWorldService).getHelloWorld();
  }

}
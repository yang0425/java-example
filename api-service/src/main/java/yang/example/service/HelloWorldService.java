package yang.example.service;

import org.springframework.stereotype.Service;
import yang.example.dto.HelloWorldDTO;
import yang.example.repository.HelloWorldRepository;

@Service
public class HelloWorldService {

  public final HelloWorldRepository helloWorldRepository;

  public HelloWorldService(
      HelloWorldRepository helloWorldRepository) {
    this.helloWorldRepository = helloWorldRepository;
  }

  public HelloWorldDTO getHelloWorld() {
    String message = helloWorldRepository.getHelloWorld();

    return new HelloWorldDTO(message);
  }
}

package yang.example.service;

import org.springframework.stereotype.Service;
import yang.example.dto.HelloWorldDto;
import yang.example.entity.HelloWorld;
import yang.example.repository.HelloWorldRepository;

@Service
public class HelloWorldService {

    private final HelloWorldRepository helloWorldRepository;

    public HelloWorldService(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    public HelloWorldDto getHelloWorld() {
        HelloWorld message = helloWorldRepository.getHelloWorld();

        return new HelloWorldDto(message.getMessage());
    }
}

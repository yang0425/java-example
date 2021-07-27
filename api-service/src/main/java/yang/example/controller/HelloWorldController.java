package yang.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yang.example.dto.HelloWorldDto;
import yang.example.service.HelloWorldService;

@RestController
@RequestMapping("helloWorld")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public HelloWorldDto helloWorld() {
        return helloWorldService.getHelloWorld();
    }
}

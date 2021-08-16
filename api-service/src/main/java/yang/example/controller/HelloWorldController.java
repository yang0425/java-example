package yang.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yang.example.dto.HelloWorldDto;
import yang.example.service.HelloWorldService;

@RestController
@RequestMapping("helloWorld")
public class HelloWorldController {

  private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

  private final HelloWorldService helloWorldService;

  public HelloWorldController(HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @GetMapping
  public HelloWorldDto helloWorld() {
    logger.info("Hello");
    return helloWorldService.getHelloWorld();
  }
}

package yang.example.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yang.example.service.RedisService;

@RestController
@RequestMapping("redis")
public class RedisController {

  private final RedisService redisService;

  public RedisController(RedisService redisService) {
    this.redisService = redisService;
  }

  @PostMapping("v1")
  public void addV1(@RequestParam String key, @RequestParam int value) {
    redisService.add(key, value);
  }

  @GetMapping("v1")
  public Map<String, Integer> listV1() {
    return redisService.list();
  }

  @GetMapping("cache")
  public String cache(@RequestParam String value){
    return redisService.cache(value);
  }
}

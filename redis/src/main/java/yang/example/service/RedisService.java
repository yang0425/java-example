package yang.example.service;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

  @Autowired
  private RedisTemplate<String, Integer> redisTemplate;

  @Autowired
  @Qualifier("redisTemplateV2")
  private RedisTemplate<String, Integer> redisTemplateV2;

  public void addV1(String key, int value) {
    redisTemplate.opsForValue().set(key, value);
  }

  public Map<String, Integer> listV1() {
    return redisTemplate.keys("*").stream()
        .collect(toMap(identity(), key -> redisTemplate.opsForValue().get(key)));
  }

  public void addV2(String key, int value) {
    redisTemplateV2.opsForValue().set(key, value);
  }

  public Map<String, Integer> listV2() {
    return redisTemplateV2.keys("*").stream()
        .collect(toMap(identity(), key -> redisTemplateV2.opsForValue().get(key)));
  }
}

package yang.example.service;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Service
public class RedisService {

    private static Logger log = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void add(String key, int value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Map<String, Integer> list() {
        return redisTemplate.keys("*").stream()
            .collect(toMap(identity(), key -> (Integer) redisTemplate.opsForValue().get(key)));
    }

    @Cacheable("test")
    public String cache(String value) {
        log.info(value);
        return value;
    }
}

package yang.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;

@Configuration
@ConditionalOnProperty(prefix = "spring.redis", name = "stockDatabase")
public class RedisV2Configuration {

  @Value("${spring.redis.stockDatabase}")
  private int databaseIndex;

  @Bean("redisTemplateV2")
  public RedisTemplate<String, Integer> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
    if (connectionFactory instanceof JedisConnectionFactory) {
      RedisStandaloneConfiguration standaloneConfiguration =
          ((JedisConnectionFactory) connectionFactory).getStandaloneConfiguration();
      Assert.notNull(standaloneConfiguration, "RedisStandaloneConfiguration must not be null!");
      standaloneConfiguration.setDatabase(databaseIndex);
      JedisConnectionFactory jedisConnectionFactory =
          new JedisConnectionFactory(standaloneConfiguration,
              ((JedisConnectionFactory) connectionFactory).getClientConfiguration());
      jedisConnectionFactory.afterPropertiesSet();
      redisTemplate.setConnectionFactory(jedisConnectionFactory);
    } else {
      redisTemplate.setConnectionFactory(connectionFactory);
    }
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
    return redisTemplate;
  }

}

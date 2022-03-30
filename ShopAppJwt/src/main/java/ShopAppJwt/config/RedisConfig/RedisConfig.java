package ShopAppJwt.config.RedisConfig;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer
                = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    //讓Redis緩存的序列化方式使用redisTemplate.getValueSerializer()
    //不在使用JDK默認的序列化方式
    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {

        RedisCacheWriter redisCacheWriter
                = RedisCacheWriter
                    .nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());

        RedisCacheConfiguration redisCacheConfiguration
                = RedisCacheConfiguration
                    .defaultCacheConfig()
                    .serializeValuesWith(
                            RedisSerializationContext
                                .SerializationPair
                                .fromSerializer(redisTemplate.getValueSerializer()))
                    .entryTtl(Duration.ofMinutes(20));


        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    } // TODO: custom individual cache TTL futher

}
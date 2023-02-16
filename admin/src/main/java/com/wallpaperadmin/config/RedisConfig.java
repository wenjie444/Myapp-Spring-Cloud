package com.wallpaperadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
   @Autowired
   RedisConnectionFactory redisConnectionFactory;

   @Bean
   public RedisTemplate<String, Object> functionDomainRedisTemplate() {
      RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
      this.initDomainRedisTemplate(redisTemplate, this.redisConnectionFactory);
      return redisTemplate;
   }

   private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
      redisTemplate.setKeySerializer(new StringRedisSerializer());
      redisTemplate.setHashKeySerializer(new StringRedisSerializer());
      redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
      redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
      redisTemplate.setConnectionFactory(factory);
   }
}

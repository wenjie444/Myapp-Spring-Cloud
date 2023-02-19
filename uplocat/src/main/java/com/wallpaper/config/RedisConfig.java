package com.wallpaper.config;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import javax.annotation.PostConstruct;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
   @Autowired
   RedisConnectionFactory redisConnectionFactory;
   @Autowired
   private RedisTemplate redisTemplate;

   @PostConstruct
   public void init() {
      this.initRedisTemplate();
   }

   private void initRedisTemplate() {
      RedisSerializer stringSerializer = this.redisTemplate.getStringSerializer();
      this.redisTemplate.setKeySerializer(stringSerializer);
      this.redisTemplate.setHashKeySerializer(stringSerializer);
      this.redisTemplate.setValueSerializer(stringSerializer);
      this.redisTemplate.setHashValueSerializer(stringSerializer);
   }

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

   @Bean
   public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
      StringRedisTemplate template = new StringRedisTemplate(factory);
      Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
      om.enableDefaultTyping(DefaultTyping.NON_FINAL);
      jackson2JsonRedisSerializer.setObjectMapper(om);
      template.setValueSerializer(jackson2JsonRedisSerializer);
      template.afterPropertiesSet();
      return template;
   }
   @Bean
   public RedissonClient redissonClient(){
      Config config = new Config();
      config.useSingleServer().setAddress("redis://112.74.125.228");
      return Redisson.create(config);
   }
}

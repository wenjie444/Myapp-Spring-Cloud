package com.wallpaper.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig implements ApplicationContextAware {
   private static final Logger log = LoggerFactory.getLogger(CommonConfig.class);

   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      RabbitTemplate rabbitTemplate = (RabbitTemplate)applicationContext.getBean(RabbitTemplate.class);
      rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
         log.error("消息发送到队列失败，响应码：{}, 失败原因：{}, 交换机: {}, 路由key：{}, 消息: {}", new Object[]{replyCode, replyText, exchange, routingKey, message.toString()});
      });
   }
}

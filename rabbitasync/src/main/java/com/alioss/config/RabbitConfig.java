package com.alioss.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitConfig {
   @Bean
   public Queue rabbitQueue() {
      return new Queue("chang-queue");
   }

   @Bean
   public FanoutExchange changFanoutExchange() {
      return new FanoutExchange("chang-Exchange");
   }

   @Bean
   public Binding bindingQueue(Queue rabbitQueue, FanoutExchange fanoutExchange) {
      return BindingBuilder.bind(rabbitQueue).to(fanoutExchange);
   }
}

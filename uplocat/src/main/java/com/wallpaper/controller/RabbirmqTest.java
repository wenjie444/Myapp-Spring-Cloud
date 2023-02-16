package com.wallpaper.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableRabbit
public class RabbirmqTest {
   @Autowired
   private RabbitTemplate rabbitTemplate;

   @Test
   public void test() {
      String s = "wenjie-queue";
      String ss = "kunyu";
      this.rabbitTemplate.convertAndSend(s, ss);
   }

   @Test
   public void test2() {
      String Exchange = "chang-Exchange";
      String s = "wenjie++++++++++++";
      this.rabbitTemplate.convertAndSend(Exchange, "", s);
      System.out.println(1111);
      System.out.println(222);
   }
}

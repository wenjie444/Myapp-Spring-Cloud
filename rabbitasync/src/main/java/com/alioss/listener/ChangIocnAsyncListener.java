package com.alioss.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ChangIocnAsyncListener {
   private int i = 0;

   @RabbitListener(
      queues = {"chang-queue"}
   )
   public void test(String s) {
      System.out.println("接收到的信息" + s + this.i);
      ++this.i;
   }

   @RabbitListener(
      bindings = {@QueueBinding(
   value = @Queue(
   name = "heng-queue"
),
   exchange = @Exchange(
   name = "heng-Exchange",
   type = "direct"
),
   key = {"chang"}
)}
   )
   public void test1(String s) {
      System.out.println("heng交换机接收到的信息" + s);
   }
}

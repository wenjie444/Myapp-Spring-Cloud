package com.alioss.listener;

import com.alioss.service.IconService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IconListener {
   @Autowired
   private IconService iconService;

   @RabbitListener(
      bindings = {@QueueBinding(
   value = @Queue(
   name = "chang-queue"
),
   exchange = @Exchange(
   name = "icon-Exchange",
   type = "direct"
),
   key = {"chang"}
)}
   )
   public void changIconQueue(String messages) {
      this.iconService.changIconUplocat(messages);
   }

   @RabbitListener(
      bindings = {@QueueBinding(
   value = @Queue(
   name = "heng-queue"
),
   exchange = @Exchange(
   name = "icon-Exchange",
   type = "direct"
),
   key = {"heng"}
)}
   )
   public void hengIconQueue(String messages) {
      this.iconService.hengIconUplocat(messages);
   }
}

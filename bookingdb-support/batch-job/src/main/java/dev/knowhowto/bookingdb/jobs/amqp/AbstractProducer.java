package dev.knowhowto.bookingdb.jobs.amqp;

import dev.knowhowto.bookingdb.jobs.AbstractJobParameters;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public abstract class AbstractProducer {
  protected final RabbitTemplate template;
  protected final AmqpQueuesProperties properties;

  public AbstractProducer(RabbitTemplate template, AmqpQueuesProperties properties) {
    this.template = template;
    this.properties = properties;
  }

  protected void send(String exchange, String routingKey, AbstractJobParameters parameters) {
    template.convertAndSend(exchange, routingKey, parameters);
  }
}

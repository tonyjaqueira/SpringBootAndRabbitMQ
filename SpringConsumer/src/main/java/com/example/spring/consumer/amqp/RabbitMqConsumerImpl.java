package com.example.spring.consumer.amqp;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.consumer.dto.Mensagem;
import com.example.spring.consumer.service.ConsumerService;

@Component
public class RabbitMqConsumerImpl implements AmqpConsumer<Mensagem>{
	
	@Autowired
	private ConsumerService service;

	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(Mensagem mensagem) {
		try {
			service.action(mensagem);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

}

package com.example.spring.producer.ampq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.spring.producer.dto.Mensagem;

/*
 * 
 * Estamos utilizando o Rabbit que é um tipo de amqp
 * 
 */

@Component
public class ProducerRabbitMq implements AmpqProducer<Mensagem>{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.request.exchenge.producer}")
	private String exchange;

	@Override
	public void producer(Mensagem message) {

		try {
			rabbitTemplate.convertAndSend(exchange, queue, message);
		} catch (Exception e) {
			//quando algum erro for dado, o mesmo será enviado para a deadlleter
			throw new AmqpRejectAndDontRequeueException(e);
		}
		
	}

}

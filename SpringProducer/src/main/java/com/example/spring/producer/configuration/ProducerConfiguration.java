package com.example.spring.producer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {

	// intanciar aqui a exchenge, a fila e o deadlleter
	
	//pegando os valores do arquivo yxl
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.request.exchenge.producer}")
	private String exchange;
	
	@Value("${spring.rabbitmq.request.deadletter.producer}")
	private String deadLetter;
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	Queue deadeLetter() {
		return new Queue(deadLetter);
	}
	
	//configurações para criação de QUeue, Exchahnge e DeadLetter de forma automática, isso poderia ser feito via interface do rabbit, mas por aqui s~]ao criadas de forma automática.
	@Bean
	Queue queue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-dead-letter-exchange", exchange);
		args.put("x-dead-letter-routing-key", deadLetter);
		return new Queue(queue, true, false, false, args);
	}

	@Bean
	public Binding bindingQueue() {
		return BindingBuilder.bind(queue())
				.to(exchange()).with(queue);
	}
	
	@Bean
	public Binding bindingQueueLetter() {
		return BindingBuilder.bind(deadeLetter())
				.to(exchange()).with(deadLetter);
	}
	
}

package com.example.spring.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.producer.ampq.AmpqProducer;
import com.example.spring.producer.dto.Mensagem;

@Service
public class RebbitMQServiceImpl implements AmqpService{
	
	@Autowired
	private AmpqProducer<Mensagem> amqp;

	@Override
	public void enviarParaConsumidor(Mensagem mensagem) {
		amqp.producer(mensagem);
	}

}

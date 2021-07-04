package com.example.spring.producer.service;

import com.example.spring.producer.dto.Mensagem;

public interface AmqpService {
	void enviarParaConsumidor(Mensagem mensagem);
}

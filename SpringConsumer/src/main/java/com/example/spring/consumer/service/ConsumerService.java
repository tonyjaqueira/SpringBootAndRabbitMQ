package com.example.spring.consumer.service;

import com.example.spring.consumer.dto.Mensagem;

public interface ConsumerService {
	void action(Mensagem mensagem) throws Exception;
}

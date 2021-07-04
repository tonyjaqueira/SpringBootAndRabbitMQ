package com.example.spring.consumer.service;

import org.springframework.stereotype.Service;

import com.example.spring.consumer.dto.Mensagem;

@Service
public class ConcumerServiceImpl implements ConsumerService{

	@Override
	public void action(Mensagem mensagem) throws Exception{
		// throw new Exception("Teste de erro deadletter");
		System.out.println("Mensagem retornada: "+mensagem.getText());
	}

}

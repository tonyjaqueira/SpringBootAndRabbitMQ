package com.example.spring.producer.ampq;

/*
 * 
 * Como nosso código é desacoplado do mensageiro, todo e qualquer broker que formos utilizar tera que implementar essa interface, 
 * nesse caso iremos usar o rabbit, por isso a classe "ProducerRabbitMQ ira implementar essa interface,"
 * mas poderia ser qualquer outro como por exmplo o activeMq.
 * 
 */
public interface AmpqProducer<T> {
	void producer(T t);
}

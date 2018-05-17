package com.codekooking.logservice.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class RabbitConfig implements RabbitListenerConfigurer {

	public static final String QUEUE_NAME = "orders-queue";
	public static final String QUEUE_DEAD_NAME = "dead-orders-queue";
	public static final String EXCHANGE_NAME = "orders-exchange";

	@Bean
	Queue ordersQueue() {

		/*return QueueBuilder.durable(QUEUE_NAME).withArgument("x-dead-letter-exchange", "")
				.withArgument("x-dead-letter-routing-key", QUEUE_DEAD_NAME).withArgument("x-message-ttl", 5000)
				.build();*/
		
		return QueueBuilder.durable(QUEUE_NAME).build();
	}

	/*@Bean
	Queue deadLetterQueue() {
		return QueueBuilder.durable(QUEUE_DEAD_NAME).build();
	}*/

	@Bean
	Exchange ordersExchange() {
		return ExchangeBuilder.topicExchange(EXCHANGE_NAME).build();
	}

	@Bean
	Binding binding(Queue ordersQueue, TopicExchange ordersExchange) {
		return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(QUEUE_NAME);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	MessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
		messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
		return messageHandlerMethodFactory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

}

package com.jms.configure;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class config {
	
	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("standalone.queus");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() throws JMSException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerUrl);
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() throws JMSException {
		return new JmsTemplate(activeMQConnectionFactory());
	}

}

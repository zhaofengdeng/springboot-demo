package com.project.activeMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.project.config.JmsConfig;

@Component
public class ActiveMQConsumer2 {
	@JmsListener(destination = JmsConfig.TOPIC, containerFactory = "jmsListenerContainerTopic")
	public void onTopicMessage(String msg) {
		System.out.println("TOPIC==============msg===============" + msg);
	}

	@JmsListener(destination = JmsConfig.QUEUE, containerFactory = "jmsListenerContainerQueue")
	public void onQueueMessage(String msg) {
		System.out.println("QUEUE==============msg===============" + msg);
	}
}

package com.project.activeMQ;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer {
	@JmsListener(destination = "my_msg")
	public void readMsg(String text) {
		System.out.println("接收到消息：" + text);
	}

	@JmsListener(destination = "my_map")
	public void readMap(Map map) {
		System.out.println(map);
	}
}

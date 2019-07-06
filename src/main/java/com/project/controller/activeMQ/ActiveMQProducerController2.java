package com.project.controller.activeMQ;

import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息发送者
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/active_mq2/producer")
public class ActiveMQProducerController2 {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	@Autowired
	private Topic topic;
	@Autowired
	private Queue queue;

	@RequestMapping("/send_topic")
	public String sendTopic(HttpServletRequest request) {
		jmsTemplate.convertAndSend(topic, request.getParameter("msg"));

		return "msg发送成功";

	}

	@RequestMapping("/send_queue")
	public String sendQueue(HttpServletRequest request) {
		jmsTemplate.convertAndSend(queue, request.getParameter("msg"));

		return "msg发送成功";

	}

}

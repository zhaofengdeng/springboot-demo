package com.project.controller.activeMQ;

import java.util.HashMap;
import java.util.Map;

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
@RequestMapping(value = "/active_mq/producer")
public class ActiveMQProducerController {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	/**
	 * 测试连接 active_mq/producer/send_msg?msg=asd
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/send_msg")
	public String sendMsg(HttpServletRequest request) {

		System.out.println(jmsMessagingTemplate);
		jmsMessagingTemplate.convertAndSend("my_msg", request.getParameter("msg"));
		return "msg发送成功";

	}

	/**
	 * 测试连接 active_mq/producer/send_map
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/send_map")
	public String sendMap() {
		Map map = new HashMap();
		map.put("mobile", "13888888888");
		map.put("content", "王总喜提兰博基尼");
		jmsMessagingTemplate.convertAndSend("my_map", map);
		return "map发送成功";
	}
}

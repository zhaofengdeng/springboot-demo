package com.project.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/pubsub")
public class RedisPubSubController {
	@Autowired
	private StringRedisTemplate redisClient;

	@RequestMapping("")
	public String message(@RequestParam("message") String message) {
		redisClient.convertAndSend("news.send", message);
		return "send news success:" + message;
	}

	@RequestMapping("/2")
	public String message2(@RequestParam("message") String message) {
		redisClient.convertAndSend("news.send2", message);
		return "send news success:" + message;
	}
}

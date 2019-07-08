package com.project.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/redis/string")
public class RedisStringController {
	@Autowired
	private StringRedisTemplate redisClient;

	@RequestMapping("/save")
	public String save(@RequestParam("key") String key, @RequestParam("value") String value) {
		redisClient.opsForValue().set(key, value);
		return "redis保存成功id是" + key + ",value是" + value;
	}

	@RequestMapping("/get")
	public String get(@RequestParam("key") String key) {
		String value = redisClient.opsForValue().get(key);
		return "redis查询成功id是" + key + ",value是" + value;
	}
}

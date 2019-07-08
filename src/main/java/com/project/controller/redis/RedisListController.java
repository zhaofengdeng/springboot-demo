package com.project.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/list")
public class RedisListController {
	@Autowired
	private StringRedisTemplate redisClient;

	@RequestMapping("/left_push")
	public String leftPush(@RequestParam("key") String key, @RequestParam("value") String value) {
		Long oldCount = redisClient.opsForList().size(key);
		redisClient.opsForList().leftPush(key, value);
		// list的个数
		Long newCount = redisClient.opsForList().size(key);
		return "redisleftPush成功<br />push之前有" + oldCount + "个<br />push之后有" + newCount + "个";
	}

	@RequestMapping("/left_pop")
	public String save(@RequestParam("key") String key) {
		// pop取值，取值成功，该值在redis中消失
		Long oldCount = redisClient.opsForList().size(key);
		String value = redisClient.opsForList().leftPop(key);
		Long newCount = redisClient.opsForList().size(key);
		return "redisleftPush成功<br />" + "pop之前有" + oldCount + "个<br />" + "pop之后有" + newCount + "个<br />," + "pop出的值是"
				+ value;
	}
}

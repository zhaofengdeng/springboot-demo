package com.project.controller.redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.RedisUserModel;

@RestController
@RequestMapping("/redis/model")
public class RedisModelController {
	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisClient;

	@RequestMapping("/save")
	public  String save(@RequestParam("key") String key, @RequestParam("id") String id,
			@RequestParam("name") String name) {
		RedisUserModel model = new RedisUserModel();
		model.setId(id);
		model.setName(name);
		redisClient.opsForValue().set("user-" + key, model);
		return "保存成功";
	}

	@RequestMapping("/get")
	public  String save(@RequestParam("key") String key) {
		RedisUserModel object = (RedisUserModel) redisClient.opsForValue().get("user-" + key);
		return "查询成功,id=" + object.getId() + ",name=" + object.getName();
	}

	@RequestMapping("/list/save")
	public  String listSave(@RequestParam("id") String id, @RequestParam("name") String name) {
		Long oldCount = redisClient.opsForList().size("users");
		RedisUserModel model = new RedisUserModel();
		model.setId(id);
		model.setName(name);
		redisClient.opsForList().leftPush("users", model);
		Long newCount = redisClient.opsForList().size("users");
		return "保存成功,之前有" + oldCount + ",之后有" + newCount;
	}

	@RequestMapping("/list/get")
	public  String listSave() {
		Long oldCount = redisClient.opsForList().size("users");

		RedisUserModel object = (RedisUserModel) redisClient.opsForList().leftPop("users");
		Long newCount = redisClient.opsForList().size("users");
		return "取值成功,之前有" + oldCount + ",之后有" + newCount + ";取出的数据是id=" + object.getId() + ",name=" + object.getName();
	}
}

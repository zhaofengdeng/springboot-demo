package com.project.service.cache;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class CacheTestService {
	@Cacheable(value = "emp", key = "targetClass + methodName +#p0")
	public String test(String id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}

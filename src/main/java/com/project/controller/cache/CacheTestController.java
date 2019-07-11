package com.project.controller.cache;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.cache.CacheTestService;

@RestController
@RequestMapping(value = "/cache/test", method = { RequestMethod.POST, RequestMethod.GET })

public class CacheTestController {
	@Autowired
	private CacheTestService service;
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request) {
		return service.test(request.getParameter("id"));
	}
}

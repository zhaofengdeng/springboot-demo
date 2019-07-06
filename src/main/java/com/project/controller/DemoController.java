package com.project.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo", method = { RequestMethod.POST, RequestMethod.GET })
public class DemoController {
	@RequestMapping(value = "/test")
	public String test(@RequestBody Map<String, Object> map) {
		return "hello word";
	}

	@RequestMapping(value = "/test2")
	public String test2(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		return "hello word2";
	}
}

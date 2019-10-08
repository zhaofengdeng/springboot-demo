package com.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@RestController
@RequestMapping(value = "/demo", method = { RequestMethod.POST, RequestMethod.GET })
public class DemoExportController {
	@Autowired
	private Configuration configuration;

	@RequestMapping(value = "/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void activeSearch(HttpServletResponse response) throws TemplateException, IOException {
	
		Template template = configuration.getTemplate("test.ftl");
		Map<String, Object> map = new HashMap<>();
		map.put("data", "测试");
		template.process(map, response.getWriter());
	}
}

package com.project.controller.ebean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;

import io.ebean.Ebean;
import io.ebean.ExpressionList;

@RestController
@RequestMapping(value = "/ebean_base", method = { RequestMethod.POST, RequestMethod.GET })
public class EbeanBaseController {
	// 测试连接
	/// ebean_base/save?name=zhaofengdeng&no=12
	@RequestMapping(value = "/save")
	public User save(HttpServletRequest request) {
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		User user = new User();
		user.setName(name);
		user.setNo(no);
		user.save();
		return user;
	}

	@RequestMapping(value = "/update")
	public User update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		ExpressionList<User> el = Ebean.find(User.class).where().eq("deleted", false);
		User user = el.eq("id", id).findOne();
		user.setName(name);
		user.setNo(no);
		user.update();
		return user;
	}

	@RequestMapping(value = "/search")
	public List<User> search(HttpServletRequest request) {
		ExpressionList<User> el = Ebean.find(User.class).where().eq("deleted", false);
		List<User> users = el.orderBy("insertedAt desc").findList();
		return users;
	}
}
